package com.helfi.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        RecyclerView recyclerView = findViewById(R.id.shopping_list_recyclerview);
        Button btnMenu = findViewById(R.id.btnMenuFromShoppingList);

        List<ShoppingItem> shoppingItems = createSampleRecipe();

        ShoppingListAdapter adapter = new ShoppingListAdapter(shoppingItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnMenu.setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class)));
    }

    private List<ShoppingItem> createSampleRecipe() {
        List<ShoppingItem> items = new ArrayList<>();
        items.add(new ShoppingItem("Mleko migdałowe", "1 litr"));
        items.add(new ShoppingItem("Banany", "3 szt"));
        items.add(new ShoppingItem("Truskawki", "500g"));
        items.add(new ShoppingItem("Granola", "200g"));
        items.add(new ShoppingItem("Miód", "150g"));
        items.add(new ShoppingItem("Kokos startowany", "100g"));
        items.add(new ShoppingItem("Nasiona chia", "50g"));
        items.add(new ShoppingItem("Jogurt naturalny", "400g"));
        return items;
    }
}
