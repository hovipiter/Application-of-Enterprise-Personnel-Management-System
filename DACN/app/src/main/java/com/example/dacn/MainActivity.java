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
    }

}