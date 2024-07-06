package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class help_page extends AppCompatActivity {

    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgback;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_page);

        // Cập nhật các thông tin về ứng dụng trong các TextViews
        TextView textViewHelpContent = findViewById(R.id.textViewHelp);

        // dashboard
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgback = findViewById(R.id.dashboard_back_img);

        // Thay đổi các giá trị để phù hợp với ứng dụng của bạn

        String helpContent = getString(R.string.help_content);
        textViewHelpContent.setText(Html.fromHtml(helpContent));

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(help_page.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(help_page.this, setting_page.class);
                startActivity(intent);
            }
        });

    }
}
