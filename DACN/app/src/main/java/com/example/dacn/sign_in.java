
package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class sign_in extends AppCompatActivity {
    TextView forgotpass;
    EditText editTextsignin_password_input, editTextsignin_staffID_input;
    Button buttonsignin_button_signin;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page);

        forgotpass = findViewById(R.id.signin_forgotpass);
        editTextsignin_password_input = findViewById(R.id.signin_password_input);
        editTextsignin_staffID_input = findViewById(R.id.signin_staffID_input);
        buttonsignin_button_signin = findViewById(R.id.signin_button_signin);
        progressBar = findViewById(R.id.progress);

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_in.this, forgot_pass.class);
                startActivity(intent);
            }
        });

        buttonsignin_button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password, staffid;
                password = String.valueOf(editTextsignin_password_input.getText());
                staffid = String.valueOf(editTextsignin_staffID_input.getText());

                if (!password.equals("") && !staffid.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "staffid";
                            field[1] = "password";

                            String[] data = new String[2];
                            data[0] = staffid;
                            data[1] = password;

                            PutData putData = new PutData("http://192.168.37.163/usermanagement/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    Log.d("LOGIN", "Result: " + result);  // Log the server response
                                    if (result.equals("Login Success")) {

                                        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("staffid", staffid);
                                        //giữ cho trạng thái đăng nhập
                                        editor.putBoolean("isLoggedIn", true); // Set isLoggedIn to true
                                        editor.apply();
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}