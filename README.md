# Application-of-Enterprise-Personnel-Management-System
Application of Enterprise Personnel Management System

#Các file cho việc đăng nhập đăng ký
- Trong thư mục xampp\htdocs tự tạo folder usermanagement (folder này chứa các file sau: )
- Để thực hiện reset password bằng cách gửi mail dùng smtp server thì ta phải cài đặt như sau:
- Vào cmd -> nhập đường dẫn xampp\htdocs\usermanagement -> mkdir phpmailer -> composer require phpmailer/phpmailer
Tạo file Database.php có nội dung như sau:

### DataBase.php

```php

<?php
require "DataBaseConfig.php";
class DataBase
{
    // Nội dung của lớp DataBase...
}
?>
```



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

