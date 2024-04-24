package com.example.dacn;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class project_page extends AppCompatActivity {
    Button newTask;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_page);

        newTask = findViewById(R.id.btnNewtask);
        newTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, project_detail_page.class);
                startActivity(intent);
            }
        });
    }
}
