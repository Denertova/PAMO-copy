package com.helfi.healthapp;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShoppingItemView extends LinearLayout {

    public ShoppingItemView(Context context) {
        super(context);
        setOrientation(HORIZONTAL);
        setPadding(20, 20, 20, 20);

        CheckBox checkBox = new CheckBox(context);
        checkBox.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(checkBox);

        LinearLayout textContainer = new LinearLayout(context);
        textContainer.setOrientation(VERTICAL);
        textContainer.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
        textContainer.setPadding(16, 0, 0, 0);

        TextView nameView = new TextView(context);
        nameView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        nameView.setTextSize(16);
        textContainer.addView(nameView);

        TextView quantityView = new TextView(context);
        quantityView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        quantityView.setTextSize(14);
        textContainer.addView(quantityView);

        addView(textContainer);
    }
}
