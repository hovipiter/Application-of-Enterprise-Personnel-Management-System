package com.example.dacn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class setting_page extends AppCompatActivity {

    LinearLayout linearLayoutLanguage, linearLayoutNotification, linearLayoutLogout, linearLayoutDeleteAccount;
    ImageView setting_back_img;

    // navigation bottom
    ImageView home, task, person, setting;

    // change mode light dark
    SharedPreferences sharedPreferences;
    Switch switchDarkMode;

    // information
    LinearLayout linearLayoutHelp, linearLayoutAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_page);

        sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE);

        // Lấy trạng thái chế độ sáng/tối từ SharedPreferences
        boolean isDarkModeOn = sharedPreferences.getBoolean("dark_mode", false);

        // Áp dụng chế độ sáng/tối cho ứng dụng
        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        findviewbyid_setting_page();
        openObject_setting_page();

        // Thiết lập Switch button với trạng thái hiện tại của chế độ sáng/tối
        switchDarkMode.setChecked(isDarkModeOn);
        // Lắng nghe sự thay đổi của Switch button để cập nhật trạng thái chế độ sáng/tối
        switchDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Lưu trạng thái mới vào SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("dark_mode", isChecked);
                editor.apply();

                // Áp dụng chế độ sáng/tối mới cho ứng dụng
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }

    public void findviewbyid_setting_page() {
        linearLayoutLanguage = findViewById(R.id.linearLanguage);
        linearLayoutNotification = findViewById(R.id.linearNotification);
        linearLayoutLogout = findViewById(R.id.setting_logout);
        linearLayoutDeleteAccount = findViewById(R.id.setting_deletAccount);
        setting_back_img = findViewById(R.id.setting_back_img);
        switchDarkMode = findViewById(R.id.setting_page_switch);
        linearLayoutHelp = findViewById(R.id.lineHelp);
        linearLayoutAbout = findViewById(R.id.lineAbout);

        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
    }

    public void openObject_setting_page() {
        linearLayoutAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(setting_page.this, about_page.class);
                startActivity(intent);
            }
        });
        linearLayoutHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(setting_page.this, help_page.class);
                startActivity(intent);
            }
        });
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

        // navigation bottom bar
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
