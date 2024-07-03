package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class notification_page extends AppCompatActivity {
    private RecyclerView notiRecycleView;
    // thanh dashboard
    AppCompatImageView imgback;
    // navigation bottom
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.notification_page);
        List<Notification> notificationList = new ArrayList<Notification>();
        notificationList.add(new Notification("1", "Title 1", "content 1", "22/12"));
        notificationList.add(new Notification("2", "Title 2", "content 2", "22/12"));
        notificationList.add(new Notification("3", "Title 3", "content 3", "22/12"));
        notificationList.add(new Notification("4", "Title 4", "content 4", "22/12"));

        notiRecycleView = findViewById(R.id.rcv_noti_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        NotificationAdapter notiAdapter = new NotificationAdapter(notificationList);
        notiRecycleView.setAdapter(notiAdapter);
        notiRecycleView.setLayoutManager(layoutManager);

        findviewbyid_notification();
        openObject_notification();

    }
    void findviewbyid_notification(){
        // dashboard
        imgback = findViewById(R.id.dashboard_back_img);
        //forum

    }

    void openObject_notification(){
        // forum
        // dashboard
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notification_page.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
