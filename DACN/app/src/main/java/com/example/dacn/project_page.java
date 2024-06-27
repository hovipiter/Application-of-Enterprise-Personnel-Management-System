package com.example.dacn;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class project_page extends AppCompatActivity {
    Button newTask;
    private RecyclerView projectRecycleView;
    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgdrawer, imgback;
    // navigation bottom
    ImageView home, task, person, setting;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_page);

        List<Project> projectList = new ArrayList<Project>();
        projectList.add(new Project("Project 1","Tạo dự án mới về xây dựng website","Thời gian còn lại", "5 ngày"));
        projectList.add(new Project("Project 1","Tạo dự án mới về xây dựng website","Thời gian còn lại", "5 ngày"));
        projectList.add(new Project("Project 1","Tạo dự án mới về xây dựng website","Thời gian còn lại", "5 ngày"));
        projectList.add(new Project("Project 1","Tạo dự án mới về xây dựng website","Thời gian còn lại", "5 ngày"));
        projectList.add(new Project("Project 1","Tạo dự án mới về xây dựng website","Thời gian còn lại", "5 ngày"));


        projectRecycleView = findViewById(R.id.rcv_projectlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        ProjectAdapter projectAdapter = new ProjectAdapter(projectList);
        projectRecycleView.setAdapter(projectAdapter);
        projectRecycleView.setLayoutManager(layoutManager);


        findviewbyid_project();
        openObject_project();

    }
    void findviewbyid_project(){
        // project page
        newTask = findViewById(R.id.btnNewtask);
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // dashboard
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgback = findViewById(R.id.dashboard_back_img);
        //forum

    }

    void openObject_project(){
        // project page
        newTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, project_detail_edit_page.class);
                startActivity(intent);
            }
        });

        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, setting_page.class);
                startActivity(intent);
            }
        });

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
