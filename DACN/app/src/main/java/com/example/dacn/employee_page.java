package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import java.util.stream.Collectors;

public class employee_page extends AppCompatActivity {
    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgdrawer, imgback;
    // navigation bottom
    ImageView home, task, person, setting;

    // page
    private Spinner departmentSpinner;
    private RecyclerView employeeRecyclerView;
    private EmployeeAdapter employeeAdapter;

    private List<Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_page);

        findviewbyid_apartment();
        openObject_apartment();

        employeeRecyclerView.setHasFixedSize(true);
        employeeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        employeeRecyclerView.setAdapter(employeeAdapter);

        employeeList = new ArrayList<>();

        LoadAllEmployee();

    }
    private void LoadAllEmployee() {
        // Define the URL for the PHP script
        String url = "http://192.168.37.163/usermanagement/fetch_employee.php";

//  Create the JsonArrayRequest
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Handle the JSON response here
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject employee = response.getJSONObject(i);
                                String username = employee.getString("username");
                                String department = employee.getString("department");

                                Employee emplyee = new Employee();
                                emplyee.setName(username);
                                emplyee.setDepartment(department);
                                employeeList.add(emplyee);

                                // Use the retrieved data (e.g., display it in the UI)
                                Log.d("EmployeeData", "Username: " + username + ", Department: " + department);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        employeeAdapter = new EmployeeAdapter(employee_page.this, employeeList);
                        employeeRecyclerView.setAdapter(employeeAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle the error here
                        Toast.makeText(employee_page.this, "Error", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(employee_page.this);
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
        departmentSpinner = findViewById(R.id.employee_page_department_spinner);
        employeeRecyclerView = findViewById(R.id.employee_recycler_view);
    }

    void openObject_apartment(){
        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_page.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_page.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_page.this, setting_page.class);
                startActivity(intent);
            }
        });

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_page.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employee_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}