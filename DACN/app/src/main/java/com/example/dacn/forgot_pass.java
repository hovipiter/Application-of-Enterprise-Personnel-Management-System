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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class forgot_pass extends AppCompatActivity {
    EditText staffid_reset, email_reset;
    Button reset_password;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pass_page);

        staffid_reset = findViewById(R.id.forgot_pass_page_staffID_input);
        email_reset = findViewById(R.id.forgot_pass_page_email_input);
        reset_password = findViewById(R.id.forgot_pass_page_button_reset);
        progressBar = findViewById(R.id.progress);

        reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String staffid = staffid_reset.getText().toString().trim();
                String email = email_reset.getText().toString().trim();

                Log.d("ForgotPassword", "StaffID: " + staffid + ", Email: " + email);

                if (!staffid.isEmpty() && !email.isEmpty()) {
                    progressBar.setVisibility(View.VISIBLE);

                    // Send data to PHP server for password reset
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "staffid";
                            field[1] = "email";
                            String[] data = new String[2];
                            data[0] = staffid;
                            data[1] = email;

                            PutData putData = new PutData("http://192.168.37.163/usermanagement/forgot_password.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                                    // Handle result
                                    if (result.equals("New Password Sent")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
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
