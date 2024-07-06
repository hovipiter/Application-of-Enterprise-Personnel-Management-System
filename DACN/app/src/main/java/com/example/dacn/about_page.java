package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class about_page extends AppCompatActivity {

    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgback;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);

        // Cập nhật các thông tin về ứng dụng trong các TextViews
        TextView textViewAppName = findViewById(R.id.textViewAppName);
        TextView textViewVersion = findViewById(R.id.textViewVersion);
        TextView textViewDescription = findViewById(R.id.textViewDescription);

        // dashboard
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgback = findViewById(R.id.dashboard_back_img);



        // Thay đổi các giá trị để phù hợp với ứng dụng của bạn
//        textViewAppName.setText("Application of Enterprise Personnel Management System");
//        textViewVersion.setText("Version 1.0");

        String appNametext = getString(R.string.yourapp);
        textViewAppName.setText(appNametext);

        String version = getString(R.string.version);
        textViewAppName.setText(version);
        // Lấy nội dung từ strings.xml
        String descriptionText = getString(R.string.description_about);

// Thiết lập nội dung cho textViewDescription
        textViewDescription.setText(Html.fromHtml(descriptionText));


        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(about_page.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(about_page.this, setting_page.class);
                startActivity(intent);
            }
        });

    }
}
