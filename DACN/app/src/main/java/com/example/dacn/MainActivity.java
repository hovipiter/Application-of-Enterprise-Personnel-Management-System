package com.example.dacn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CardView  chamcong, salary, nghiphep, contract, department, forum, chinhsach;
    CardView project;
    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgback;
    // navigation bottom
    ImageView home, task, person, setting;
    TextView welcome1, welcome2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        findviewbyid();
        openObject();

        // Check if user is logged in
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (!isLoggedIn) {
            // Redirect to login page
            Intent intent = new Intent(this, sign_in.class);
            startActivity(intent);
            finish(); // Close MainActivity to prevent going back
        }
    }

    void findviewbyid(){
        project =  (CardView) findViewById(R.id.cardviewProject);
        chamcong =  (CardView) findViewById(R.id.cardViewChamcong);
        salary = (CardView) findViewById(R.id.cardViewSalary);
        nghiphep = (CardView) findViewById(R.id.cardViewNghiphep);
        contract = (CardView) findViewById(R.id.cardViewContract);
        department = (CardView) findViewById(R.id.cardViewApartment);
        forum = (CardView) findViewById(R.id.cardViewForum);
        chinhsach = (CardView) findViewById(R.id.cardViewChinhSach);
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // dashboard
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgback = findViewById(R.id.dashboard_back_img);
        // welcome
        welcome1 = findViewById(R.id.main_welcome1_textview);
        welcome2 = findViewById(R.id.main_welcome2_textview);

    }
    void openObject(){
        // main
        department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, employee_page.class);
                startActivity(intent);
            }
        });

        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, project_page.class);
                startActivity(intent);
            }
        });

        chamcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, chamcong_page.class);
                startActivity(intent);
            }
        });

        nghiphep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, nghiphep_page.class);
                startActivity(intent);
            }
        });

        salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, salary_page.class);
                startActivity(intent);
            }
        });

        contract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, contract_page.class);
                startActivity(intent);
            }
        });

        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, forum_page.class);
                startActivity(intent);
            }
        });


        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, setting_page.class);
                startActivity(intent);
            }
        });

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // banner
        welcome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, project_page.class);
                startActivity(intent);
            }
        });

        welcome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, project_page.class);
                startActivity(intent);
            }
        });

    }


}