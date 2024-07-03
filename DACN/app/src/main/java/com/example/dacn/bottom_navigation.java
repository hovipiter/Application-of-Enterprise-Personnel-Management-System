package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class bottom_navigation extends AppCompatActivity {
    ImageView home, task, person, setting;
    LinearLayout lin_home, lin_task, lin_person, lin_settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation);

        //home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        //person = findViewById(R.id.nav_task_icon);
        //setting = findViewById(R.id.nav_settings_icon);
        lin_home = findViewById(R.id.nav_home);
        lin_task = findViewById(R.id.nav_task);
        lin_person = findViewById(R.id.nav_person);
        lin_settings = findViewById(R.id.nav_settings);

        openNavObject();
    }
    public void openNavObject(){
        lin_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bottom_navigation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bottom_navigation.this, project_page.class);
                startActivity(intent);
            }
        });
    }
}
