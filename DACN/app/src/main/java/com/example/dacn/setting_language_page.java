package com.example.dacn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class setting_language_page extends AppCompatActivity {

    LinearLayout linearLayoutFont, linearLayoutFontSize;
    ImageView setting_back_img;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        String language = sharedPreferences.getString("My_Lang", "en");
        setLocale(language);

        setContentView(R.layout.setting_language_page);
        findviewbyid_setting_language_page();
        openObject_setting_language_page();

        Spinner spinner = findViewById(R.id.setting_spinner_language);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, R.layout.setting_language_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Đặt sự kiện chọn ngôn ngữ
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = position == 0 ? "vi" : "en";
                String currentLanguage = sharedPreferences.getString("My_Lang", "en");

                if (!selectedLanguage.equals(currentLanguage)) {
                    setLocale(selectedLanguage);
                    recreate(); // Khởi động lại Activity để áp dụng ngôn ngữ mới
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Đặt lựa chọn spinner dựa trên ngôn ngữ hiện tại
        if (language.equals("en")) {
            spinner.setSelection(1);
        } else {
            spinner.setSelection(0);
        }
    }

    public void findviewbyid_setting_language_page() {
        linearLayoutFont = findViewById(R.id.linearFont);
        linearLayoutFontSize = findViewById(R.id.linearFontSize);
        setting_back_img = findViewById(R.id.setting_back_img);
    }

    public void openObject_setting_language_page() {
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

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        config.locale = locale;
        resources.updateConfiguration(config, dm);

        // Lưu trạng thái ngôn ngữ vào SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }
}
