package com.helfi.healthapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingViewHolder> {

    private final List<ShoppingItem> items;

    public ShoppingListAdapter(List<ShoppingItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_item_layout, parent, false);
        return new ShoppingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        ShoppingItem item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ShoppingViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox itemCheckBox;

        private final TextView itemName;

        private final TextView itemQuantity;

        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemCheckBox = itemView.findViewById(R.id.shopping_item_checkbox);
            this.itemName = itemView.findViewById(R.id.shopping_item_name);
            this.itemQuantity = itemView.findViewById(R.id.shopping_item_quantity);
        }

        public void bind(ShoppingItem item) {
            itemName.setText(item.getName());
            itemQuantity.setText(item.getQuantity());
            itemCheckBox.setChecked(item.isPurchased());

            itemCheckBox.setOnCheckedChangeListener((buttonView, isChecked) ->
                    item.setPurchased(isChecked));
        }
    }
}
