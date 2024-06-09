package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class new_forum extends AppCompatActivity {
    // navigation bottom
    ImageView home, task, person, setting;
    ImageButton back;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.forum_created);

        findviewbyid_new_forum();
        openObject_new_forum();
    }

    void findviewbyid_new_forum(){
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        //forum
        back = findViewById(R.id.new_forum_back_imgbtn);

    }

    void openObject_new_forum(){
        // forum
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(new_forum.this, forum_page.class);
                startActivity(intent);
            }
        });

        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(new_forum.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(new_forum.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(new_forum.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(new_forum.this, setting_page.class);
                startActivity(intent);
            }
        });

    }
}
