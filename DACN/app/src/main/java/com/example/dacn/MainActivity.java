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

public class MainActivity extends AppCompatActivity {
    ImageView  chamcong, salary, nghiphep, contract, department, forum, chinhsach;


    CardView project;
    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgviewuser, imgdrawer;
    AppCompatTextView tvdashboard;
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
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgviewuser = (AppCompatImageView) findViewById(R.id.ib_user);
        imgdrawer = (AppCompatImageView) findViewById(R.id.ib_back);
        tvdashboard = (AppCompatTextView) findViewById(R.id.text_dashboard);

    }
    void openObject(){
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
        contract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, contract_page.class);
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
        nghiphep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, nghiphep_page.class);
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
        department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, apartment_page.class);
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
        imgviewuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, user_page.class);
                startActivity(intent);
            }
        });

        imgdrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, user_page.class);
                startActivity(intent);
            }
        });
        tvdashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}