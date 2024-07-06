package com.example.dacn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class salary_page extends AppCompatActivity {
    TextView detail, salaryText, otherFeeText, bonusText, sumText;
    AppCompatImageView imgbtnnotification, imgdrawer, imgback;
    ImageView home, task, person, setting;
    Button searchbtn;
    TextView textViewStartDay, textViewReceiveDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salary_page);

        findviewbyid_salary();
        openObject_salary();

        // Fetch salary details
        fetchSalaryDetails();
    }

    public void findviewbyid_salary() {
        //detail = findViewById(R.id.salary_page_detail);
        searchbtn = findViewById(R.id.salary_page_search_btn);
        salaryText = findViewById(R.id.salary_page_salary_number);
        otherFeeText = findViewById(R.id.salary_page_other_fee_number);
        bonusText = findViewById(R.id.salary_page_award_number);
        sumText = findViewById(R.id.salary_page_sum_number);

        textViewStartDay = findViewById(R.id.salary_detail_page_startday);
        textViewReceiveDay = findViewById(R.id.salary_detail_page_receive_day);

        home = findViewById(R.id.nav_home_icon);
        task = findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);

        imgbtnnotification = findViewById(R.id.ib_noti);
        imgback = findViewById(R.id.dashboard_back_img);
    }

    public void openObject_salary() {
//        detail.setOnClickListener(v -> {
//            Intent intent = new Intent(salary_page.this, salary_search_page.class);
//            startActivity(intent);
//        });

        searchbtn.setOnClickListener(v -> {
            Intent intent = new Intent(salary_page.this, salary_search_page.class);
            startActivity(intent);
        });

        home.setOnClickListener(v -> {
            Intent intent = new Intent(salary_page.this, MainActivity.class);
            startActivity(intent);
        });

        task.setOnClickListener(v -> {
            Intent intent = new Intent(salary_page.this, project_page.class);
            startActivity(intent);
        });

        person.setOnClickListener(v -> {
            Intent intent = new Intent(salary_page.this, profile_page.class);
            startActivity(intent);
        });

        setting.setOnClickListener(v -> {
            Intent intent = new Intent(salary_page.this, setting_page.class);
            startActivity(intent);
        });

        imgbtnnotification.setOnClickListener(v -> {
            Intent intent = new Intent(salary_page.this, notification_page.class);
            startActivity(intent);
        });

        imgback.setOnClickListener(v -> {
            Intent intent = new Intent(salary_page.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void fetchSalaryDetails() {

        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        String staffid = sharedPreferences.getString("staffid", null);
        // Gọi trang PHP để lấy thông tin từ server
        String url = "http://192.168.37.163/usermanagement/salary.php?staffid=" + staffid;

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if (jsonObject.has("salary")) {
                            int salary = jsonObject.getInt("salary");
                            int otherFee = jsonObject.getInt("otherefee");
                            int bonus = jsonObject.getInt("bonus");
                            int sum = salary + otherFee + bonus;
                            String startDay = jsonObject.getString("startday");
                            String endDay = jsonObject.getString("endday");

                            salaryText.setText(String.valueOf(salary));
                            otherFeeText.setText(String.valueOf(otherFee));
                            bonusText.setText(String.valueOf(bonus));
                            sumText.setText(String.valueOf(sum));
                            textViewStartDay.setText(startDay);
                            textViewReceiveDay.setText(endDay);
                        } else {
                            // Handle the case where no payroll information was found
                            // Show a message or handle accordingly
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> error.printStackTrace()
        );

        queue.add(stringRequest);
    }
}
