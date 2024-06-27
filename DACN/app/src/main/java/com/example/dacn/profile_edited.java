package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class profile_edited extends AppCompatActivity {
    // thanh dashboard
    // navigation bottom
    ImageView home, task, person, setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edited);

        findviewbyid_profile_edited();
        openObject_profile_edited();
    }

    void findviewbyid_profile_edited(){
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // dashboard
        //forum

    }

    void openObject_profile_edited(){
        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_edited.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_edited.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_edited.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_edited.this, setting_page.class);
                startActivity(intent);
            }
        });

    }
}