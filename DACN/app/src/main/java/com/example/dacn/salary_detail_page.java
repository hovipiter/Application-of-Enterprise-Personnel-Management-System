package com.example.dacn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class salary_detail_page extends AppCompatActivity {
    // Dashboard components
    AppCompatImageView imgbtnnotification, imgdrawer, imgback;
    // Navigation bottom bar
    ImageView home, task, person, setting;

    TextView textViewSalaryNumber, textViewBonusNumber, textViewOtherfeeNumber
         , textViewSumNumber;
    TextView textViewStartDay, textViewReceiveDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salary_detail_page);

        findviewbyid_salary();
        openObject_salary();
        Intent intent = getIntent();

        String month = intent.getStringExtra("month");
        String year = intent.getStringExtra("year");

        fetchSalaryData(month, year);
    }

    private void fetchSalaryData(String month, String year) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        String staffid = sharedPreferences.getString("staffid", null);
        String url = "http://192.168.37.163/usermanagement/search_salary.php?staffid=" + staffid + "&month=" + month + "&year=" + year;
        // Sử dụng thư viện Volley để gửi yêu cầu HTTP
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String salary = response.getString("salary");
                            String bonus = response.getString("bonus");
                            String otherFee = response.getString("otherefee");
                            String total = response.getString("total");
                            String startDay = response.getString("startday");
                            String endDay = response.getString("endday");

                            textViewSalaryNumber.setText(salary);
                            textViewOtherfeeNumber.setText(otherFee);
                            textViewBonusNumber.setText(bonus);
                            textViewSumNumber.setText(total);

                            textViewStartDay.setText(startDay);
                            textViewReceiveDay.setText(endDay);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        queue.add(jsonObjectRequest);
    }
//    private void fetchSalaryDetails() {
//        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
//        String staffid = sharedPreferences.getString("staffid", null);
//        // Log the staffid to make sure it's being retrieved correctly
//        Log.d("fetchSalaryDetails", "StaffID: " + staffid);
//
//        // Call PHP script to get the data from the server
//        String url = "http://192.168.37.163/usermanagement/salary.php?staffid=" + staffid;
//        Log.d("fetchSalaryDetails", "Request URL: " + url);
//
//        RequestQueue queue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> {
//                    Log.d("fetchSalaryDetails", "Response: " + response);
//                    try {
//                        JSONObject jsonObject = new JSONObject(response);
//                        if (jsonObject.has("salary")) {
//                            int salary = jsonObject.getInt("salary");
//                            int otherFee = jsonObject.getInt("otherefee");
//                            int bonus = jsonObject.getInt("bonus");
//                            String startDay = jsonObject.getString("startday");
//                            String endDay = jsonObject.getString("endday");
//                            int sum = salary + otherFee + bonus;
//
//                            textViewSalaryNumber.setText(String.valueOf(salary));
//                            textViewOtherfeeNumber.setText(String.valueOf(otherFee));
//                            textViewBonusNumber.setText(String.valueOf(bonus));
//                            textViewSumNumber.setText(String.valueOf(sum));
//
//                            textViewStartDay.setText(startDay);
//                            textViewReceiveDay.setText(endDay);
//                        } else {
//                            Log.d("fetchSalaryDetails", "No payroll information found for this Staff ID.");
//                        }
//                    } catch (JSONException e) {
//                        Log.e("fetchSalaryDetails", "JSON Parsing error: " + e.getMessage());
//                    }
//                },
//                error -> Log.e("fetchSalaryDetails", "Volley error: " + error.getMessage())
//        );
//
//        queue.add(stringRequest);
//    }


    public void findviewbyid_salary() {
        // Navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // Dashboard
        imgbtnnotification = findViewById(R.id.ib_noti);
        imgback = findViewById(R.id.dashboard_back_img);
        // Page components
        textViewSalaryNumber = findViewById(R.id.salary_detail_page_time_number);
        textViewBonusNumber = findViewById(R.id.salary_detail_page_award_number);

        textViewSumNumber = findViewById(R.id.salary_detail_page_sum_number);
        textViewOtherfeeNumber = findViewById(R.id.salary_detail_page_other_number);

        textViewStartDay = findViewById(R.id.salary_detail_page_startday);
        textViewReceiveDay = findViewById(R.id.salary_detail_page_receive_day);
    }

    public void openObject_salary() {
        // Navigation bottom bar
        home.setOnClickListener(v -> {
            Intent intent = new Intent(salary_detail_page.this, MainActivity.class);
            startActivity(intent);
        });

        task.setOnClickListener(v -> {
            Intent intent = new Intent(salary_detail_page.this, project_page.class);
            startActivity(intent);
        });

        person.setOnClickListener(v -> {
            Intent intent = new Intent(salary_detail_page.this, profile_page.class);
            startActivity(intent);
        });

        setting.setOnClickListener(v -> {
            Intent intent = new Intent(salary_detail_page.this, setting_page.class);
            startActivity(intent);
        });

        // Dashboard
        imgbtnnotification.setOnClickListener(v -> {
            Intent intent = new Intent(salary_detail_page.this, notification_page.class);
            startActivity(intent);
        });
        imgback.setOnClickListener(v -> {
            Intent intent = new Intent(salary_detail_page.this, salary_page.class);
            startActivity(intent);
        });
    }
}
