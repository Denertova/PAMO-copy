package com.helfi.healthapp;

public class ShoppingItem {

    private final String name;

    private final String quantity;

    private boolean isPurchased;

    public ShoppingItem(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
        this.isPurchased = false;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }
}
