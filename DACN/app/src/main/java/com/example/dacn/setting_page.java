package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class setting_page extends AppCompatActivity {

    LinearLayout linearLayoutLanguage, linearLayoutNotification, linearLayoutLogout, linearLayoutDeleteAccount;
    ImageView setting_back_img;

    // navigation bottom
    ImageView home, task, person, setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_page);

        findviewbyid_setting_page();
        openObject_setting_page();

    }
    public void findviewbyid_setting_page(){
        linearLayoutLanguage = findViewById(R.id.linearLanguage);
        linearLayoutNotification = findViewById(R.id.linearNotification);
        linearLayoutLogout = findViewById(R.id.setting_logout);
        linearLayoutDeleteAccount = findViewById(R.id.setting_deletAccount);
        setting_back_img = findViewById(R.id.setting_back_img);
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
    }

    public  void openObject_setting_page(){
        linearLayoutLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_page.this, setting_language_page.class);
                startActivity(intent);
            }
        });

        linearLayoutNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_page.this, setting_notification_page.class);
                startActivity(intent);
            }
        });

        setting_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        linearLayoutLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_page.this, sign_in.class);
                startActivity(intent);
            }
        });

        linearLayoutDeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_page.this, sign_in.class);
                startActivity(intent);
                Toast.makeText(setting_page.this, "Đã xóa tài khoản", Toast.LENGTH_SHORT).show();
            }
        });

        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_page.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_page.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_page.this, setting_page.class);
                startActivity(intent);
            }
        });
    }
}