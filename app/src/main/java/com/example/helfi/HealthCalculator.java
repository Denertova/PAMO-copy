package com.example.helfi;

public class HealthCalculator {
    public static double calculateBmi(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    public static String bmiCategory(double bmi) {
        if (bmi < 18.5) return "Niedowaga";
        if (bmi < 25) return "Waga prawidłowa";
        if (bmi < 30) return "Nadwaga";
        return "Otyłość";
    }

    public static int calculateCalories(double weightKg, double heightCm, double ageYears, int activityIndex) {
        double bmr = 88.36 + (13.4 * weightKg) + (4.8 * heightCm) - (5.7 * ageYears);
        double factor = 1.2;
        switch (activityIndex) {
            case 1:
                factor = 1.375;
                break;
            case 2:
                factor = 1.55;
                break;
            case 3:
                factor = 1.725;
                break;
            default:
                break;
        }
        return (int) Math.round(bmr * factor);
    }
}
