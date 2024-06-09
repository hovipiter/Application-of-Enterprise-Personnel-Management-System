package com.example.dacn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class setting_language_page extends AppCompatActivity {

    LinearLayout linearLayoutFont, linearLayoutFontSize;
    ImageView setting_back_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_language_page);

        findviewbyid_setting_language_page();
        openObject_setting_language_page();

        Spinner spinner = findViewById(R.id.setting_spinner_language);

        // Tạo dữ liệu cho Spinne

        // Tạo adapter cho Spinner với custom layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, R.layout.setting_language_spinner_item);

        // Chỉ định layout được sử dụng khi danh sách các mục Spinner xuất hiện
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Áp dụng adapter cho Spinner
        spinner.setAdapter(adapter);


    }
    public void findviewbyid_setting_language_page(){
        linearLayoutFont = findViewById(R.id.linearFont);
        linearLayoutFontSize = findViewById(R.id.linearFontSize);
        setting_back_img = findViewById(R.id.setting_back_img);
    }
    public void openObject_setting_language_page(){
        linearLayoutFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_language_page.this, setting_font_page.class);
                startActivity(intent);
            }
        });

        linearLayoutFontSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_language_page.this, setting_fontsize_page.class);
                startActivity(intent);
            }
        });

        setting_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting_language_page.this, setting_page.class);
                startActivity(intent);
            }
        });
    }
}
