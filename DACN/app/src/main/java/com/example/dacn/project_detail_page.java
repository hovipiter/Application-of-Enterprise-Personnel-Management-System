package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class project_detail_page extends AppCompatActivity {


    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgback;
    // navigation bottom
    ImageView home, task, person, setting;

    // To do list
    private TaskAdapter taskAdapter;
    private List<Task> tasks;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_detail_page);

        findviewbyid_project_detail();
        openObject_project_detail();

        tasks = new ArrayList<>();
        taskAdapter = new TaskAdapter(tasks);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(taskAdapter);

        TextView buttonAddTask = findViewById(R.id.buttonAddTask);
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasks.add(new Task(""));
                taskAdapter.notifyItemInserted(tasks.size() - 1);
            }
        });
    }

    void findviewbyid_project_detail(){

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

    void openObject_project_detail(){
        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_detail_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_detail_page.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_detail_page.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_detail_page.this, setting_page.class);
                startActivity(intent);
            }
        });

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_detail_page.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_detail_page.this, project_page.class);
                startActivity(intent);
            }
        });
    }
}