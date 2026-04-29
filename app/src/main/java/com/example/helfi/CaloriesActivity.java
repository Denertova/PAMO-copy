package com.example.helfi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class CaloriesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        TextInputEditText weight = findViewById(R.id.weight);
        TextInputEditText height = findViewById(R.id.height);
        TextInputEditText age = findViewById(R.id.age);
        AutoCompleteTextView activity = findViewById(R.id.activityLevel);
        TextView result = findViewById(R.id.result);

        // Set up activity level dropdown
        String[] levels = getResources().getStringArray(R.array.activity_levels);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, levels);
        activity.setAdapter(adapter);

        Button menu = findViewById(R.id.btnMenu);
        menu.setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class)));

        findViewById(R.id.calculate).setOnClickListener(v -> {
            try {
                String weightStr = weight.getText().toString();
                String heightStr = height.getText().toString();
                String ageStr = age.getText().toString();
                String activityStr = activity.getText().toString();

                if (weightStr.isEmpty() || heightStr.isEmpty() || ageStr.isEmpty() || activityStr.isEmpty()) {
                    result.setText("Wypełnij wszystkie pola");
                    return;
                }

                double w = Double.parseDouble(weightStr);
                double h = Double.parseDouble(heightStr);
                double a = Double.parseDouble(ageStr);

                double bmr = 88.36 + (13.4 * w) + (4.8 * h) - (5.7 * a);

                double factor = 1.2;
                int selectedIndex = -1;
                for (int i = 0; i < levels.length; i++) {
                    if (levels[i].equals(activityStr)) {
                        selectedIndex = i;
                        break;
                    }
                }

                switch (selectedIndex) {
                    case 1: factor = 1.375; break;
                    case 2: factor = 1.55; break;
                    case 3: factor = 1.725; break;
                }

                double calories = bmr * factor;
                result.setText("Twoje dzienne zapotrzebowanie:\n" + (int) calories + " kcal");

            } catch (Exception e) {
                result.setText("Błędne dane");
            }
        });
    }
}