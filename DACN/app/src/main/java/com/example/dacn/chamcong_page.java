package com.example.dacn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class chamcong_page extends AppCompatActivity {
    // thanh dashboard
    AppCompatImageView imgbtnnotification, imgdrawer, imgback;
    // navigation bottom
    ImageView home, task, person, setting;
    // chamcong
    ImageButton nghiphep_imgbtn, location_imgbtn, recog_imgbtn;
    TextView textViewDone;

    Switch diemDanhSwitch;
    LinearLayout leaveRequestLayout, locationLayout, recogniseLayout;
    TextView leaveRequestTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chamcong_page);

        findviewbyid_chamcong();
        openObject_chamcong();

        diemDanhSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    leaveRequestLayout.setAlpha(0.5f);
                    leaveRequestTextView.setEnabled(false);
                    nghiphep_imgbtn.setEnabled(false);
                } else {
                    leaveRequestLayout.setAlpha(1.0f);
                    leaveRequestTextView.setEnabled(true);
                    nghiphep_imgbtn.setEnabled(true);
                }
            }
        });

        // nếu 3 cái đều hoàn thành, hiện lên một hình dấu tích
        // còn nếu chưa hoàn thành thì không được back trở về
        locationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleMaps();
            }
        });

        recogniseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chamcong_page.this, chamcong_camera.class);
                startActivity(intent);
            }
        });
    }

    void findviewbyid_chamcong(){
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // dashboard
        imgbtnnotification = (AppCompatImageView) findViewById(R.id.ib_noti);
        imgback = findViewById(R.id.dashboard_back_img);
        // chamcong
        nghiphep_imgbtn = findViewById(R.id.Chamcong_nghiphep_imgbtn);
        location_imgbtn = findViewById(R.id.Chamcong_location_imgbtn);
        recog_imgbtn = findViewById(R.id.Chamcong_recognize_imgbtn);

        diemDanhSwitch = findViewById(R.id.chamcong_page_switch);

        leaveRequestTextView = findViewById(R.id.chamcong_page_nghiphep);
        textViewDone = findViewById(R.id.chamcong_page_done);

        locationLayout = findViewById(R.id.chamcong_page_location_layout);
        leaveRequestLayout = findViewById(R.id.chamcong_page_leaverequest_layout);
        recogniseLayout = findViewById(R.id.chamcong_page_recognise_layout);

    }

    void openObject_chamcong(){
        // chamcong
        nghiphep_imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, nghiphep_page.class);
                startActivity(intent);
            }
        });
        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, project_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, profile_page.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, setting_page.class);
                startActivity(intent);
            }
        });

        // dashboard
        imgbtnnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, notification_page.class);
                startActivity(intent);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void openGoogleMaps() {
        // Chỉnh sửa tọa độ vị trí mong muốn
        String location = "geo:0,0?q=10.762622,106.660172(Ho Chi Minh City)";
        Uri gmmIntentUri = Uri.parse(location);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        String message = getString(R.string.google_maps_not_available);
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            Toast.makeText(chamcong_page.this, message, Toast.LENGTH_LONG).show();
        }
    }

}
