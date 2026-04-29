package com.example.helfi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        List<ShoppingItem> shoppingItems = new ArrayList<>();
        shoppingItems.add(new ShoppingItem("Płatki owsiane"));
        shoppingItems.add(new ShoppingItem("Banany"));
        shoppingItems.add(new ShoppingItem("Jogurt naturalny"));
        shoppingItems.add(new ShoppingItem("Miód"));
        shoppingItems.add(new ShoppingItem("Orzechy włoskie"));

        RecyclerView recyclerView = findViewById(R.id.shoppingRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ShoppingAdapter(shoppingItems));

        findViewById(R.id.btnMenu).setOnClickListener(v -> finish());
    }
}
