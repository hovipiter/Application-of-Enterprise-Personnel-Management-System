package com.example.dacn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class forum_page extends AppCompatActivity {
    private RecyclerView forumRecycleView;
    Button new_forum;
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

        new_forum = findViewById(R.id.btnNewForum);
        new_forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (forum_page.this, new_forum.class);
                startActivity(intent);
            }
        });


    }
}
