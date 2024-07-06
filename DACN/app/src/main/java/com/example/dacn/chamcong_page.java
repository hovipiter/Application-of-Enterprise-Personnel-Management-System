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

import androidx.annotation.Nullable;
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

    private boolean isRecogniseUploaded = false;

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
                updateDoneTextView();
            }
        });

        locationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleMaps();
            }
        });

        nghiphep_imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, nghiphep_page.class);
                startActivity(intent);
            }
        });
        leaveRequestTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chamcong_page.this, nghiphep_page.class);
                startActivity(intent);
            }
        });

        recogniseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chamcong_page.this, chamcong_camera.class);
                startActivityForResult(intent, 3); // Request code 3 for recognise
            }
        });
        recog_imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chamcong_page.this, chamcong_camera.class);
                startActivityForResult(intent, 3); // Request code 3 for recognise
            }
        });

        location_imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleMaps();
            }
        });

        // nếu 3 cái đều hoàn thành, hiện lên một hình dấu tích
        // còn nếu chưa hoàn thành thì không được back trở về
    }

    void findviewbyid_chamcong(){
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // dashboard
        imgbtnnotification = findViewById(R.id.ib_noti);
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
        // nghỉ phep

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3 && resultCode == RESULT_OK) {
            isRecogniseUploaded = true;
            updateDoneTextView();
        }
    }

    private void updateDoneTextView() {
        if (diemDanhSwitch.isChecked() && isRecogniseUploaded) {
            textViewDone.setTextColor(getResources().getColor(R.color.green));
        } else {
            textViewDone.setTextColor(getResources().getColor(R.color.black));
        }
    }

    private void openGoogleMaps() {
        // Location coordinates for Ho Chi Minh City
        double latitude = 10.762622;
        double longitude = 106.660172;
        String label = "Ho Chi Minh City";

        // Create a URI string with geo coordinates and label
        String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude + "(" + label + ")";
        Uri gmmIntentUri = Uri.parse(uri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        // Check if Google Maps app is available
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            // If Google Maps app is not available, inform the user
            Toast.makeText(this, "Google Maps app is not installed", Toast.LENGTH_SHORT).show();
            // Optionally, handle this case by opening maps in a web browser or suggesting an alternative
        }
    }

}
