package com.helfi.healthapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMIActivity extends AppCompatActivity {

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        EditText weight = findViewById(R.id.weight);
        EditText height = findViewById(R.id.height);
        TextView result = findViewById(R.id.result);

        Button menu = findViewById(R.id.btnMenu);
        menu.setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class)));

        findViewById(R.id.calculate).setOnClickListener(v -> {
            try {
                double w = Double.parseDouble(weight.getText().toString());
                double h = Double.parseDouble(height.getText().toString()) / 100;

                double bmi = w / (h * h);

                String text;
                if (bmi < 18.5) text = "Niedowaga";
                else if (bmi < 25) text = "Waga prawidłowa";
                else if (bmi < 30) text = "Nadwaga";
                else text = "Otyłość";

                result.setText("BMI: " + String.format("%.2f", bmi) + "\n" + text);
            } catch (Exception e) {
                result.setText("Wprowadź poprawne dane");
            }
        });
    }
}
