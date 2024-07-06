package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
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

public class contract_page extends AppCompatActivity {
    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgdrawer, imgback;
    // navigation bottom
    ImageView home, task, person, setting;

    // page
    private RecyclerView contractRecyclerView;
    private ContractAdapter contractAdapter;

    private List<Contract> contractList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contract_page);

        findviewbyid_apartment();
        openObject_apartment();

        contractRecyclerView.setHasFixedSize(true);
        contractRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        contractList = new ArrayList<>();
        contractAdapter = new ContractAdapter(contract_page.this, contractList);
        contractRecyclerView.setAdapter(contractAdapter);

        LoadInformationDepartment("");

    }
    private void LoadInformationDepartment(String department) {
        // Define the URL for the PHP script
        String url = "http://192.168.37.163/usermanagement/fetch_department.php";

        // Create the JsonArrayRequest
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Handle the JSON response here
                        contractList.clear();
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject contract = response.getJSONObject(i);
                                String departmentName = contract.getString("department");
                                String phoneNumber = contract.getString("phonenumber");

                                Contract contract_information = new Contract();
                                contract_information.setName(departmentName); // Sửa thành departmentName
                                contract_information.setPhoneNumber(phoneNumber);
                                contractList.add(contract_information);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        contractAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle the error here
                        Toast.makeText(contract_page.this, "Error", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(contract_page.this);
        requestQueue.add(request);
    }


    void findviewbyid_apartment(){
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // dashboard
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgback = findViewById(R.id.dashboard_back_img);
        //
        contractRecyclerView = findViewById(R.id.contract_page_recycle_view);
    }

    void openObject_apartment(){
        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contract_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contract_page.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contract_page.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contract_page.this, setting_page.class);
                startActivity(intent);
            }
        });

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contract_page.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contract_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}