package com.example.dacn;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class forum_page extends AppCompatActivity {
    private RecyclerView forumRecycleView;
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


    }
}
