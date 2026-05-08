package com.helfi.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BMIChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_chart);

        Button menuBtn = findViewById(R.id.btnMenu);
        menuBtn.setOnClickListener(v -> startActivity(new Intent(this, MenuActivity.class)));
    }
}
