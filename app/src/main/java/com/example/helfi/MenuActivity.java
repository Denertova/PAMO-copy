package com.example.helfi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.btnBMI).setOnClickListener(v ->
                startActivity(new Intent(this, BMIActivity.class)));

        findViewById(R.id.btnCalories).setOnClickListener(v ->
                startActivity(new Intent(this, CaloriesActivity.class)));

        findViewById(R.id.btnShopping).setOnClickListener(v ->
                startActivity(new Intent(this, ShoppingActivity.class)));
    }
}
