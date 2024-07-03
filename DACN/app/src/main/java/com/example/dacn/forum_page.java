package com.example.dacn;

import android.annotation.SuppressLint;
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

public class forum_page extends AppCompatActivity {
    private RecyclerView forumRecycleView;
    Button new_forum;
    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgdrawer, imgback;
    // navigation bottom
    ImageView home, task, person, setting;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.forum_page);
        List<Forum> forumList = new ArrayList<Forum>();
        forumList.add(new Forum("Title forum","Content forum", R.drawable.like3, "Thích", R.drawable.comment3, "Bình luận", R.drawable.share, "Share"));
        forumList.add(new Forum("Title forum","Content forum", R.drawable.like3, "Thích", R.drawable.comment3, "Bình luận", R.drawable.share, "Share"));
        forumList.add(new Forum("Title forum","Content forum", R.drawable.like3, "Thích", R.drawable.comment3, "Bình luận", R.drawable.share, "Share"));
        forumList.add(new Forum("Title forum","Content forum", R.drawable.like3, "Thích", R.drawable.comment3, "Bình luận", R.drawable.share, "Share"));
        forumList.add(new Forum("Title forum","Content forum", R.drawable.like3, "Thích", R.drawable.comment3, "Bình luận", R.drawable.share, "Share"));

        forumRecycleView = findViewById(R.id.rcv_forum);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        ForumAdapter forumAdapter = new ForumAdapter(forumList);
        forumRecycleView.setAdapter(forumAdapter);
        forumRecycleView.setLayoutManager(layoutManager);

        findviewbyid_forum();
        openObject_forum();
    }
    void findviewbyid_forum(){
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // dashboard
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgback = findViewById(R.id.dashboard_back_img);
        //forum
        new_forum = findViewById(R.id.forum_page_create_post);
    }

    void openObject_forum(){
        // forum
        new_forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (forum_page.this, new_forum.class);
                startActivity(intent);
            }
        });
        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forum_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forum_page.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forum_page.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forum_page.this, project_page.class);
                startActivity(intent);
            }
        });

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forum_page.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forum_page.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
