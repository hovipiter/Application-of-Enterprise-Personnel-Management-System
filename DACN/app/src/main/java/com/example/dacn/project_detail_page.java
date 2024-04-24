package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class project_detail_page extends AppCompatActivity {
    Button editDetailProject;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_detail_page);

        editDetailProject = findViewById(R.id.btn_editDetailproject);
        editDetailProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_detail_page.this, project_detail_edit_page.class);
                startActivity(intent);
            }
        });
    }
}