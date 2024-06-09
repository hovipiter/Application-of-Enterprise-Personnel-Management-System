package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class setting_notification_page extends AppCompatActivity {

    ImageView setting_back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_notification_page);

        findviewbyid_setting_page();
        openObject_setting_page();
    }

    public void findviewbyid_setting_page(){
        setting_back_img = findViewById(R.id.setting_back_img);
    }

    public  void openObject_setting_page(){
        setting_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_notification_page.this, setting_page.class);
                startActivity(intent);
            }
        });
    }
}