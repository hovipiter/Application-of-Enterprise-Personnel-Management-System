package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.FetchData;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;

public class profile_page extends AppCompatActivity {
    Button edituser;

    TextView textViewStaffID, textViewUsername, textViewPosition, textViewDateOfBirth, textViewNation,
            textViewGender, textViewPhoneNumber, textViewAddress, textViewIDCard,
            textViewNationality, textViewStatus
            , textViewLanguage, textViewStartDate, textViewEmail;
       //     textViewDepartment;

    // navigation bottom
    ImageView home, task, person, setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        findviewbyid_profile();
        openObject_profile();

        // Lấy staffid từ SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        String staffid = sharedPreferences.getString("staffid", null);
        // Gọi trang PHP để lấy thông tin từ server
        String url = "http://192.168.37.163/usermanagement/get_user_info.php?staffid=" + staffid;
        FetchData fetchData = new FetchData(url);
        if (fetchData.startFetch()) {
            if (fetchData.onComplete()) {
                String result = fetchData.getResult();
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    textViewStaffID.setText(jsonObject.getString("staffid"));
                    textViewUsername.setText(jsonObject.getString("username"));
                    textViewPosition.setText(jsonObject.getString("position"));
                    textViewDateOfBirth.setText(jsonObject.getString("dateofbirth"));
                    textViewGender.setText(jsonObject.getString("gender"));
                    textViewAddress.setText(jsonObject.getString("address"));
                    textViewPhoneNumber.setText(jsonObject.getString("phonenumber"));
                    textViewIDCard.setText(jsonObject.getString("idcard"));
                    textViewNationality.setText(jsonObject.getString("nationality"));
                    textViewNation.setText(jsonObject.getString("nation"));

                    textViewLanguage.setText(jsonObject.getString("languages"));
                    textViewStartDate.setText(jsonObject.getString("startdate"));
        //          textViewDepartment.setText(jsonObject.getString("department"));

                    textViewStatus.setText(jsonObject.getString("status"));

                    textViewEmail.setText(jsonObject.getString("email"));


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error parsing user data", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show();
        }
    }

    // ngoài oncreate
    void findviewbyid_profile(){
        edituser = findViewById(R.id.profile_component_edit_btn);
        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);
        // profile
        textViewStaffID = findViewById(R.id.profile_page_ID);
        textViewUsername = findViewById(R.id.profile_page_username_title);
        textViewPosition = findViewById(R.id.profile_page_position);
        textViewDateOfBirth = findViewById(R.id.profile_component_date_of_birth);
        textViewGender = findViewById(R.id.profile_component_gender);
        textViewPhoneNumber = findViewById(R.id.profile_component_phone_number);
        textViewIDCard = findViewById(R.id.profile_component_id_card);
        textViewNationality = findViewById(R.id.profile_component_nationality);
        textViewNation = findViewById(R.id.profile_component_national);
        textViewStatus = findViewById(R.id.profile_component_status);

        textViewAddress = findViewById(R.id.profile_component_address);

        textViewLanguage = findViewById(R.id.profile_component_foreign_proficiency);
        textViewStartDate = findViewById(R.id.profile_component_start_date);
//     textViewDepartment = findViewById(R.id.profile_component_department);
        textViewEmail = findViewById(R.id.profile_component_email);
    }
    void openObject_profile(){
        edituser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_page.this, profile_edited.class);
                startActivity(intent);
            }
        });
        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_page.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_page.this, project_page.class);
                startActivity(intent);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_page.this, setting_page.class);
                startActivity(intent);
            }
        });
    }
}
