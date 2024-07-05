# Application-of-Enterprise-Personnel-Management-System
Application of Enterprise Personnel Management System

#Các file cho việc đăng nhập đăng ký
- Trong thư mục xampp\htdocs tự tạo folder usermanagement (folder này chứa các file sau: )
- Để thực hiện reset password bằng cách gửi mail dùng smtp server thì ta phải cài đặt như sau:
- Vào cmd -> nhập đường dẫn xampp\htdocs\usermanagement -> mkdir phpmailer -> composer require phpmailer/phpmailer
Tạo file Database.php có nội dung như sau:
<pre>
    ```
<?php
require "DataBaseConfig.php";
class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $staffid, $password)
    {
        $staffid = $this->prepareData($staffid);
        $password = $this->prepareData($password);
        $this->sql = "SELECT * FROM " . $table . " WHERE staffid = '" . $staffid . "' AND password = '" . $password . "'";
        $result = mysqli_query($this->connect, $this->sql);

        if (mysqli_num_rows($result) != 0) {
            return true;  // Login successful
        } else {
            return false; // Incorrect password or staff ID
        }
    }

    public function forgotPassword($table, $staffid, $email)
    {
        $username = $this->prepareData($staffid);
        $email = $this->prepareData($email);
        $this->sql = "SELECT * FROM " . $table . " WHERE staffid = '" . $staffid . "' AND email = '" . $email . "'";
        $result = mysqli_query($this->connect, $this->sql);
        if (mysqli_num_rows($result) != 0) {
            $newPassword = $this->generateRandomPassword();
            $hashedPassword = password_hash($newPassword, PASSWORD_DEFAULT);
            $updateSql = "UPDATE " . $table . " SET password = '" . $hashedPassword . "' WHERE staffid = '" . $staffid . "'";
            if (mysqli_query($this->connect, $updateSql)) {
                if ($this->sendEmail($email, $newPassword)) {
                    return true;
                } else {
                    return false; // Email sending failed
                }
            } else {
                return false; // Password update failed
            }
        } else {
            return false; // Staff ID or email not found
        }
    }

    private function generateRandomPassword($length = 8)
    {
        return substr(str_shuffle("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"), 0, $length);
    }
    private function sendEmail($email, $newPassword)
    {
        $subject = "Your New Password";
        $message = "Your new password is: " . $newPassword;
        $headers = "From: no-reply@yourdomain.com";
        return mail($email, $subject, $message, $headers);
    }
}
?>
    
    ```
    
</pre>


File DataBaseConfig có nội dung như sau:
<?php

class DataBaseConfig
{
    public $servername;
    public $username;
    public $password;
    public $databasename;

    public function __construct()
    {
        $this->servername = 'localhost';
        $this->username = 'root';
        $this->password = '';
        $this->databasename = 'usermanager';}
}
?>

File login.php có nội dung như sau:
<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['password']) && isset($_POST['staffid'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("login", $_POST['staffid'], $_POST['password'])) {
            echo "Login Success";
        } else echo "Password, or Staff ID wrong";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>

File forgot_password có nội dung như sau:
<?php
require "DataBase.php";
require 'vendor/autoload.php';

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

function sendResetEmail($email, $newPassword) {
    $mail = new PHPMailer(true);
    try {
        $mail->SMTPDebug = 0; // Disable verbose debug output
        $mail->isSMTP();
        $mail->Host = 'smtp.gmail.com';
        $mail->SMTPAuth = true;
        $mail->Username = 'tranhuynhngoc03112003@gmail.com';
        $mail->Password = 'zyxqiojpdnqdylkc'; // Ensure this is the correct app password
        $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;
        $mail->Port = 587;

        $mail->setFrom('tranhuynhngoc03112003@gmail.com');
        $mail->addAddress($email);
        $mail->isHTML(true);

        $mail->Subject = 'Password Reset Request';
        $mail->Body    = "Your new password is: $newPassword";

        $mail->send();
        return true;
    } catch (Exception $e) {
        return false;
    }
}

$db = new DataBase();

if (isset($_POST['staffid']) && isset($_POST['email'])) {
    if ($db->dbConnect()) {
        $staffid = $db->prepareData($_POST['staffid']);
        $email = $db->prepareData($_POST['email']);

        // Retrieve email associated with the staffid
        $sql = "SELECT email FROM login WHERE staffid = '$staffid'";
        $result = mysqli_query($db->connect, $sql);

        if (mysqli_num_rows($result) > 0) {
            $row = mysqli_fetch_assoc($result);
            $dbEmail = $row['email'];

            // Check if the provided email matches the email in database
            if ($email == $dbEmail) {
                // Generate a random new password
                $newPassword = substr(md5(rand()), 0, 7);

                // Update password in database (store plaintext new password)
                $updateSql = "UPDATE login SET password = '$newPassword' WHERE staffid = '$staffid'";
                if (mysqli_query($db->connect, $updateSql)) {
                    // Send email with new password (plaintext)
                    if (sendResetEmail($email, $newPassword)) {
                        echo "New Password Sent";
                    } else {
                        echo "Failed to send email.";
                    }
                } else {
                    echo "Failed to update password.";
                }
            } else {
                echo "Email does not match.";
            }
        } else {
            echo "Staff ID not found.";
        }
    } else {
        echo "Error: Database connection";
    }
} else {
    echo "All fields are required";
}
file_put_contents('debug.log', print_r($_POST, true), FILE_APPEND);
?>

