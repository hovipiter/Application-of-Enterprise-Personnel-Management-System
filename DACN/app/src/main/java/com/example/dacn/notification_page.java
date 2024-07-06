package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class notification_page extends AppCompatActivity {
    // thanh dashboard
    ImageView imgback;
    // page
    private RecyclerView notificationRecycleView;
    private NotificationAdapter notificationAdapter;
    private List<Notification> notificationList;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.notification_page);

        findviewbyid_notification();
        openObject_notification();

        notificationRecycleView.setHasFixedSize(true);
        notificationRecycleView.setLayoutManager(new LinearLayoutManager(this));

        notificationList = new ArrayList<>();
        notificationAdapter = new NotificationAdapter(notification_page.this, notificationList);
        notificationRecycleView.setAdapter(notificationAdapter);

        LoadNotification("");

//        notificationList.add(new Notification("1", "Title 1", "content 1", "22/12"));
//        notificationList.add(new Notification("2", "Title 2", "content 2", "22/12"));
//        notificationList.add(new Notification("3", "Title 3", "content 3", "22/12"));
//        notificationList.add(new Notification("4", "Title 4", "content 4", "22/12"));
//        notificationRecycleView = findViewById(R.id.rcv_noti_list);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        NotificationAdapter notiAdapter = new NotificationAdapter(notification_page.this, notificationList);
//        notificationRecycleView.setAdapter(notiAdapter);
//        notificationRecycleView.setLayoutManager(layoutManager);

    }

    void LoadNotification(String notification){
        // Define the URL for the PHP script
        String url = "http://192.168.37.163/usermanagement/fetch_notice.php";

        // Create the JsonArrayRequest
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Handle the JSON response here
                        notificationList.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject contract = response.getJSONObject(i);
                                String notificationTitle = contract.getString("notice_title");
                                String notificationContent = contract.getString("notice_content");
                                String notificationDate = contract.getString("notice_date");

                                Notification noti = new Notification();
                                noti.setTitle(notificationTitle); // Sửa thành departmentName
                                noti.setContent(notificationContent);
                                noti.setDay(notificationDate);
                                notificationList.add(noti);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        notificationAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle the error here
                        Toast.makeText(notification_page.this, "Error", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(notification_page.this);
        requestQueue.add(request);

    }
    void findviewbyid_notification(){
        // dashboard
        imgback = findViewById(R.id.notification_back_img);
        notificationRecycleView = findViewById(R.id.rcv_noti_list);

    }
    void openObject_notification(){
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notification_page.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
