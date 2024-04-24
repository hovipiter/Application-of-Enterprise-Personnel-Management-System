package com.example.dacn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView  chamcong, salary, nghiphep, contract, department, forum, chinhsach;
    CardView project;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        project =  (CardView) findViewById(R.id.cardviewProject);
        chamcong =  (ImageView) findViewById(R.id.imgChamCong);
        salary = (ImageView) findViewById(R.id.imgBangLuong);
        nghiphep = (ImageView) findViewById(R.id.imgNghiPhep);
        contract = (ImageView) findViewById(R.id.imgHopDong);
        department = (ImageView) findViewById(R.id.imgPhongBan);
        forum = (ImageView) findViewById(R.id.imgForum);
        chinhsach = (ImageView) findViewById(R.id.imgChinhSach);

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
    }
}