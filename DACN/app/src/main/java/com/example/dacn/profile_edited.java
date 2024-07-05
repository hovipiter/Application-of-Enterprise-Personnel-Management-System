package com.example.dacn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.FetchData;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class profile_edited extends AppCompatActivity {
    EditText editTextPosition, editTextDateOfBirth, editTextGender, editTextPhoneNumber, editTextAddress,
            editTextIDCard, editTextNationality, editTextNation, editTextLanguages, editTextStartDate,
             editTextEmail, editTextDepartment;
    TextView textViewUsername, textViewID, textViewPosition, textViewStatus;

    Button saveButton;
    // navigation bottom
    ImageView home, task, person, setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edited);

        // navigation bottom bar
        home = findViewById(R.id.nav_home_icon);
        task = (ImageView) findViewById(R.id.nav_task_icon);
        person = findViewById(R.id.nav_person_icon);
        setting = findViewById(R.id.nav_settings_icon);

        openObject();

        editTextDateOfBirth = findViewById(R.id.profile_component_edited_page_date_of_birth);
        editTextGender = findViewById(R.id.profile_component_edited_page_gender);
        editTextPhoneNumber = findViewById(R.id.profile_component_edited_page_phone_number);
        editTextAddress = findViewById(R.id.profile_component_edited_page_address);
        editTextIDCard = findViewById(R.id.profile_component_edited_page_idcard);
        editTextNationality = findViewById(R.id.profile_component_edited_page_nationality);
        editTextNation = findViewById(R.id.profile_component_edited_page_national);
        editTextLanguages = findViewById(R.id.profile_component_edited_page_language_proficiency);
        editTextStartDate = findViewById(R.id.profile_component_edited_page_start_date);
        editTextEmail = findViewById(R.id.profile_component_edited_page_email);
        editTextDepartment = findViewById(R.id.profile_component_edited_page_department);

        textViewUsername = findViewById(R.id.profile_edited_page_username_title);
        textViewID  = findViewById(R.id.profile_edited_page_ID);
        textViewPosition = findViewById(R.id.profile_edited_page_position);
        textViewStatus = findViewById(R.id.profile_component_edited_page_Status);

        saveButton = findViewById(R.id.profile_component_edited_page_save_btn);


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
                    textViewUsername.setText(jsonObject.getString("username"));
                    textViewID.setText(jsonObject.getString("staffid"));
                    textViewPosition.setText(jsonObject.getString("position"));
                    editTextDateOfBirth.setText(jsonObject.getString("dateofbirth"));
                    editTextGender.setText(jsonObject.getString("gender"));
                    editTextPhoneNumber.setText(jsonObject.getString("phonenumber"));
                    editTextAddress.setText(jsonObject.getString("address"));
                    editTextIDCard.setText(jsonObject.getString("idcard"));
                    editTextNationality.setText(jsonObject.getString("nationality"));
                    editTextNation.setText(jsonObject.getString("nation"));
                    editTextLanguages.setText(jsonObject.getString("languages"));
                    editTextStartDate.setText(jsonObject.getString("startdate"));
                    editTextDepartment.setText(jsonObject.getString("department"));
                    textViewStatus.setText(jsonObject.getString("status"));
                    editTextEmail.setText(jsonObject.getString("email"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error parsing user data", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show();
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> postDataParams = new HashMap<>();
                postDataParams.put("staffid", staffid);
                postDataParams.put("dateofbirth", editTextDateOfBirth.getText().toString());
                postDataParams.put("gender", editTextGender.getText().toString());
                postDataParams.put("phonenumber", editTextPhoneNumber.getText().toString());
                postDataParams.put("address", editTextAddress.getText().toString());
                postDataParams.put("idcard", editTextIDCard.getText().toString());
                postDataParams.put("nationality", editTextNationality.getText().toString());
                postDataParams.put("nation", editTextNation.getText().toString());
                postDataParams.put("languages", editTextLanguages.getText().toString());
                postDataParams.put("startdate", editTextStartDate.getText().toString());
                postDataParams.put("department", editTextDepartment.getText().toString());
                postDataParams.put("email", editTextEmail.getText().toString());

                sendPostRequest("http://192.168.37.163/usermanagement/update_user_info.php", postDataParams);

                Intent intent2 = new Intent(profile_edited.this, profile_page.class);
                startActivity(intent2);
            }
        });
    }

    private void sendPostRequest(String requestURL, HashMap<String, String> postDataParams) {
        class SendPostRequestAsync extends AsyncTask<Void, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... voids) {
                URL url;
                String response = "";
                try {
                    url = new URL(requestURL);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(15000);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    writer.write(getPostDataString(postDataParams));
                    writer.flush();
                    writer.close();
                    os.close();

                    int responseCode = conn.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = in.readLine()) != null) {
                            sb.append(line);
                        }
                        in.close();
                        response = sb.toString();
                    } else {
                        response = "Error: " + responseCode;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return response;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                if (result.equals("Update Success")) {
                    Intent intent = new Intent(profile_edited.this, profile_page.class);
                    startActivity(intent);
                }
            }
        }

        new SendPostRequestAsync().execute();
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return result.toString();
    }
    void openObject(){

        //navigation bottom bar
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_edited.this, MainActivity.class);
                startActivity(intent);
            }
        });

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_edited.this, project_page.class);
                startActivity(intent);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_edited.this, setting_page.class);
                startActivity(intent);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_edited.this, profile_page.class);
                startActivity(intent);
            }
        });
    }
}
