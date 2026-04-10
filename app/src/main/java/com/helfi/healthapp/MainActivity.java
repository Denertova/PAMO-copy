package com.helfi.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.btnStart);
        start.setOnClickListener(v -> startActivity(new Intent(this, com.helfi.healthapp.MenuActivity.class)));
    }
}
