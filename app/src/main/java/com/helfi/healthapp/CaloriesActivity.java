package com.helfi.healthapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CaloriesActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        EditText weight = findViewById(R.id.weight);
        EditText height = findViewById(R.id.height);
        EditText age = findViewById(R.id.age);
        Spinner activity = findViewById(R.id.activityLevel);
        TextView result = findViewById(R.id.result);

        Button menu = findViewById(R.id.btnMenu);
        menu.setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class)));

        findViewById(R.id.calculate).setOnClickListener(v -> {
            try {
                double w = Double.parseDouble(weight.getText().toString());
                double h = Double.parseDouble(height.getText().toString());
                double a = Double.parseDouble(age.getText().toString());

                double calories = CaloriesCalculator.calculateDailyCalories(w, h, a, activity.getSelectedItemPosition());
                result.setText("Kalorie dzienne: " + (int) calories + " kcal");

            } catch (Exception e) {
                result.setText("Błędne dane");
            }
        });
    }
}
