package com.example.dacn;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class project_page extends AppCompatActivity {
    Button newTask;
    private RecyclerView projectRecycleView;
    private ProjectAdapter projectAdapter;
    private List<Project> projectList;
    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgback;
    // navigation bottom
    ImageView home, task, person, setting;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_page);
        findviewbyid_project();

//        List<Project> projectList = new ArrayList<Project>();
//        projectList.add(new Project("Project name","Create website","Timeleft", "5 days"));
//        projectList.add(new Project("Project name","Create website","Timeleft", "5 days"));
//        projectList.add(new Project("Project name","Create website","Timeleft", "5 days"));
//        projectList.add(new Project("Project name","Create website","Timeleft", "5 days"));
//        projectList.add(new Project("Project name","TCreate website","Timeleft", "5 days"));

        projectRecycleView.setHasFixedSize(true);
        projectRecycleView.setLayoutManager(new LinearLayoutManager(this));

        projectList = new ArrayList<>();
        projectAdapter = new ProjectAdapter(project_page.this, projectList);
        projectRecycleView.setAdapter(projectAdapter);

        fetchProjectDetails();


        openObject_project();

    }
//    private void fetchProjectDetails() {
//
//        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
//        String staffid = sharedPreferences.getString("staffid", null);
//        // Gọi trang PHP để lấy thông tin từ server
//        String url = "http://192.168.37.163/usermanagement/fetch_project.php?staffid=" + staffid;
//
//        RequestQueue queue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> {
//                    try {
//                        JSONObject jsonObject = new JSONObject(response);
//                        if (jsonObject.has("project")) {
//                            String projectname = jsonObject.getString("projectname");
//                            String progress = jsonObject.getString("progress");
//                            String startDay = jsonObject.getString("startday");
//                            String endDay = jsonObject.getString("endday");
//
//                            Project get_project = new Project();
//                            get_project.setProjecttitle(projectname);
//                            get_project.setProgress(progress);
//                            get_project.setStartday(startDay);
//                            get_project.setEndday(endDay);
//                            projectList.add(get_project);
//
//                        } else {
//                            // Handle the case where no payroll information was found
//                            // Show a message or handle accordingly
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                },
//                error -> error.printStackTrace()
//        );
//
//        queue.add(stringRequest);
//    }
private void fetchProjectDetails() {
    // Get staff ID from SharedPreferences
    SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
    String staffid = sharedPreferences.getString("staffid", null);

    // Make network request to fetch project details
    String url = "http://192.168.37.163/usermanagement/fetch_project.php?staffid=" + staffid;
    RequestQueue queue = Volley.newRequestQueue(this);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if (jsonObject.has("projectname")) {
                            String projectname = jsonObject.getString("projectname");
                            String progress = jsonObject.getString("progress");
                            String startDay = jsonObject.getString("startday");
                            String endDay = jsonObject.getString("endday");

                            // Create Project object and add to list
                            Project project = new Project();
                            project.setProjecttitle(projectname);
                            project.setProgress(progress);
                            project.setStartday(startDay);
                            project.setEndday(endDay);
                            projectList.add(project);

                            // Notify adapter about data change
                            projectAdapter.notifyDataSetChanged();
                        } else {
                            String errorMessage = jsonObject.getString("error");
                            Toast.makeText(project_page.this, errorMessage, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(project_page.this, "JSON Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    Toast.makeText(project_page.this, "Error fetching project details: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

    queue.add(stringRequest);
}

    void findviewbyid_project(){
        // project page
        projectRecycleView = findViewById(R.id.recyclerViewProjects);
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // dashboard
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgback = findViewById(R.id.dashboard_back_img);
        //forum
    }

    void openObject_project(){
        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, setting_page.class);
                startActivity(intent);
            }
        });

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project_page.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
