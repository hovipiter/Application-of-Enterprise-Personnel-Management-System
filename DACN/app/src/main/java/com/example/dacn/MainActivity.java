package com.example.dacn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageView  chamcong, salary, nghiphep, contract, department, forum, chinhsach;
    CardView project;
    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgdrawer;
    // navigation bottom
    ImageView home, task, person, setting;
    LinearLayout lin_home, lin_task, lin_person, lin_settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        findviewbyid();
        openObject();
    }

    void findviewbyid(){
        project =  (CardView) findViewById(R.id.cardviewProject);
        chamcong =  (ImageView) findViewById(R.id.imgChamCong);
        salary = (ImageView) findViewById(R.id.imgBangLuong);
        nghiphep = (ImageView) findViewById(R.id.imgNghiPhep);
        contract = (ImageView) findViewById(R.id.imgHopDong);
        department = (ImageView) findViewById(R.id.imgPhongBan);
        forum = (ImageView) findViewById(R.id.imgForum);
        chinhsach = (ImageView) findViewById(R.id.imgChinhSach);
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // dashboard
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgdrawer = (AppCompatImageView) findViewById(R.id.ib_back);

    }
    void openObject(){
        // main
        department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, apartment_page.class);
                startActivity(intent);
            }
        });

        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, project_page.class);
                startActivity(intent);
            }
        });

        chamcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, chamcong_page.class);
                startActivity(intent);
            }
        });

        nghiphep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, nghiphep_page.class);
                startActivity(intent);
            }
        });

        salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, salary_page.class);
                startActivity(intent);
            }
        });

        contract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, contract_page.class);
                startActivity(intent);
            }
        });

        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, forum_page.class);
                startActivity(intent);
            }
        });


        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, project_page.class);
                startActivity(intent);
            }
        });

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, notification_page.class);
                startActivity(intent);
            }
        });




    }


}