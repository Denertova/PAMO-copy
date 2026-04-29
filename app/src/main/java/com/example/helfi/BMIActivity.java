package com.example.helfi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMIActivity extends AppCompatActivity {
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        EditText weight = findViewById(R.id.weight);
        EditText height = findViewById(R.id.height);
        TextView result = findViewById(R.id.result);

        BMIChartView chartView = findViewById(R.id.bmiChart);
        chartView.setValues(java.util.Arrays.asList(19.3f, 19.5f, 19.6f, 19.7f, 19.4f));

        Button menu = findViewById(R.id.btnMenu);
        menu.setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class)));

        findViewById(R.id.calculate).setOnClickListener(v -> {
            try {
                double w = Double.parseDouble(weight.getText().toString());
                double h = Double.parseDouble(height.getText().toString());

                double bmi = HealthCalculator.calculateBmi(w, h);
                String text = HealthCalculator.bmiCategory(bmi);
                result.setText("BMI: " + String.format("%.2f", bmi) + "\n" + text);
            } catch (Exception e) {
                result.setText("Wprowadź poprawne dane");
            }
        });
    }
}
