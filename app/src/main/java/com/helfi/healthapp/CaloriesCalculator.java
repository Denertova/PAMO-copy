package com.helfi.healthapp;

public class CaloriesCalculator {

    public static double calculateBMR(double weight, double height, double age) {
        return 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
    }

    public static double getActivityFactor(int activityLevel) {
        return switch (activityLevel) {
            case 1 -> 1.375;
            case 2 -> 1.55;
            case 3 -> 1.725;
            default -> 1.2;
        };
    }

    public static double calculateDailyCalories(double weight, double height, double age, int activityLevel) {
        double bmr = calculateBMR(weight, height, age);
        double factor = getActivityFactor(activityLevel);
        return bmr * factor;
    }
}
