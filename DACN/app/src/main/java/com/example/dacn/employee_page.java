package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private List<Department> departmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_page);

        findviewbyid_apartment();
        openObject_apartment();

        // Initialize data
        initializeData();

        // Set up RecyclerView
        employeeAdapter = new EmployeeAdapter(employeeList); // Set initial list to show all employees
        employeeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        employeeRecyclerView.setAdapter(employeeAdapter);

        // Set up Spinner
        List<String> departmentNames = new ArrayList<>();
        departmentNames.add("All Departments"); // Option to show all employees
        departmentNames.addAll(departmentList.stream().map(Department::getName).collect(Collectors.toList()));

        ArrayAdapter<String> departmentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, departmentNames);
        departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentSpinner.setAdapter(departmentAdapter);

        // Spinner item selected listener
        departmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedDepartment = departmentNames.get(position);
                if (selectedDepartment.equals("All Departments")) {
                    employeeAdapter.setEmployeeList(employeeList);
                } else {
                    List<Employee> filteredEmployees = employeeList.stream()
                            .filter(employee -> employee.getDepartment().equals(selectedDepartment))
                            .collect(Collectors.toList());
                    employeeAdapter.setEmployeeList(filteredEmployees);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void initializeData() {
        // Sample data
        departmentList = new ArrayList<>();
        departmentList.add(new Department("HR"));
        departmentList.add(new Department("IT"));
        departmentList.add(new Department("Finance"));

        employeeList = new ArrayList<>();
        employeeList.add(new Employee("John Doe", "HR"));
        employeeList.add(new Employee("Jane Smith", "IT"));
        employeeList.add(new Employee("Mike Johnson", "Finance"));
        employeeList.add(new Employee("Sarah Williams", "HR"));
        employeeList.add(new Employee("Tom Brown", "IT"));
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