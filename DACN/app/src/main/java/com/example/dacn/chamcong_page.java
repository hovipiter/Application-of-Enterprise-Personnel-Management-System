package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class chamcong_page extends AppCompatActivity {
    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgdrawer, imgback;
    // navigation bottom
    ImageView home, task, person, setting;
    // chamcong
    ImageButton nghiphep_imgbtn, location_imgbtn, recog_imgbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chamcong_page);

        findviewbyid_chamcong();
        openObject_chamcong();
    }

    void findviewbyid_chamcong(){
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // dashboard
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgdrawer = (AppCompatImageView) findViewById(R.id.ib_dashboard);
        imgback = findViewById(R.id.dashboard_back_img);
        // chamcong
        nghiphep_imgbtn = findViewById(R.id.Chamcong_nghiphep_imgbtn);
        location_imgbtn = findViewById(R.id.Chamcong_location_imgbtn);
        recog_imgbtn = findViewById(R.id.Chamcong_recognize_imgbtn);
    }

    void openObject_chamcong(){
        // chamcong
        nghiphep_imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, nghiphep_page.class);
                startActivity(intent);
            }
        });
        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, setting_page.class);
                startActivity(intent);
            }
        });

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
