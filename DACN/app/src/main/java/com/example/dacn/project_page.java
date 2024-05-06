package com.example.dacn;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class project_page extends AppCompatActivity {
    Button newTask;
    private RecyclerView projectRecycleView;
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

        newTask = findViewById(R.id.btnNewtask);
        newTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, project_detail_edit_page.class);
                startActivity(intent);
            }
        });


    }
}
