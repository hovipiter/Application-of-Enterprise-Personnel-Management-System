package com.example.dacn;


import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class project_page extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_page);

        EditText editText = findViewById(R.id.edt_allproject);
        editText.setEnabled(false);
    }
}
