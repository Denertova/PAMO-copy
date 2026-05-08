package com.helfi.healthapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CaloriesCalculatorTest {

    private static final double DELTA = 0.01;

    @Before
    public void setUp() {
        //
    }

    @Test
    public void testCalculateBMR_withTypicalValues() {
        double weight = 70;
        double height = 175;
        double age = 30;

        double bmr = CaloriesCalculator.calculateBMR(weight, height, age);

        assertEquals(1695.36, bmr, DELTA);
    }

    @Test
    public void testGetActivityFactor_sedentary() {
        double factor = CaloriesCalculator.getActivityFactor(0);

        assertEquals(1.2, factor, DELTA);
    }

    @Test
    public void testGetActivityFactor_lightlyActive() {
        double factor = CaloriesCalculator.getActivityFactor(1);

        assertEquals(1.375, factor, DELTA);
    }

    @Test
    public void testGetActivityFactor_moderatelyActive() {
        double factor = CaloriesCalculator.getActivityFactor(2);

        assertEquals(1.55, factor, DELTA);
    }

    @Test
    public void testGetActivityFactor_veryActive() {
        double factor = CaloriesCalculator.getActivityFactor(3);

        assertEquals(1.725, factor, DELTA);
    }

    @Test
    public void testGetActivityFactor_invalidIndex() {
        double factor = CaloriesCalculator.getActivityFactor(5);

        assertEquals(1.2, factor, DELTA);
    }

    @Test
    public void testCalculateDailyCalories_sedentary() {
        double weight = 70;
        double height = 175;
        double age = 30;
        int activityLevel = 0;

        double calories = CaloriesCalculator.calculateDailyCalories(weight, height, age, activityLevel);

        double expectedBMR = 1695.36;
        double expected = expectedBMR * 1.2;
        assertEquals(expected, calories, DELTA);
    }

    @Test
    public void testCalculateDailyCalories_moderatelyActive() {
        double weight = 70;
        double height = 175;
        double age = 30;
        int activityLevel = 2;

        double calories = CaloriesCalculator.calculateDailyCalories(weight, height, age, activityLevel);

        double expectedBMR = 1695.36;
        double expected = expectedBMR * 1.55;
        assertEquals(expected, calories, DELTA);
    }

    @Test
    public void testCalculateDailyCalories_veryActive() {
        double weight = 70;
        double height = 175;
        double age = 30;
        int activityLevel = 3;

        double calories = CaloriesCalculator.calculateDailyCalories(weight, height, age, activityLevel);

        double expectedBMR = 1695.36;
        double expected = expectedBMR * 1.725;
        assertEquals(expected, calories, DELTA);
    }

    @Test
    public void testCalculateDailyCalories_femaleExample() {
        double weight = 65;
        double height = 165;
        double age = 28;
        int activityLevel = 1;

        double calories = CaloriesCalculator.calculateDailyCalories(weight, height, age, activityLevel);

        double expectedBMR = 88.36 + (13.4 * 65) + (4.8 * 165) - (5.7 * 28);
        double expected = expectedBMR * 1.375;
        assertEquals(expected, calories, DELTA);
    }

    @Test
    public void testCalculateDailyCalories_maleExample() {
        double weight = 85;
        double height = 185;
        double age = 35;
        int activityLevel = 3;

        double calories = CaloriesCalculator.calculateDailyCalories(weight, height, age, activityLevel);

        double expectedBMR = 88.36 + (13.4 * 85) + (4.8 * 185) - (5.7 * 35);
        double expected = expectedBMR * 1.725;
        assertEquals(expected, calories, DELTA);
    }

    @Test
    public void testCaloriesIncrease_withWeight() {
        double lightPersonCalories = CaloriesCalculator.calculateDailyCalories(60, 170, 30, 1);
        double heavyPersonCalories = CaloriesCalculator.calculateDailyCalories(100, 170, 30, 1);

        assertTrue(heavyPersonCalories > lightPersonCalories);
    }

    @Test
    public void testCaloriesIncrease_withHeight() {
        double shortPersonCalories = CaloriesCalculator.calculateDailyCalories(70, 150, 30, 1);
        double tallPersonCalories = CaloriesCalculator.calculateDailyCalories(70, 200, 30, 1);

        assertTrue(tallPersonCalories > shortPersonCalories);
    }

    @Test
    public void testCaloriesDecrease_withAge() {
        double youngerCalories = CaloriesCalculator.calculateDailyCalories(70, 170, 20, 1);
        double olderCalories = CaloriesCalculator.calculateDailyCalories(70, 170, 60, 1);

        assertTrue(youngerCalories > olderCalories);
    }

    @Test
    public void testCaloriesIncrease_withActivityLevel() {
        double sedentaryCalories = CaloriesCalculator.calculateDailyCalories(70, 170, 30, 0);
        double veryActiveCalories = CaloriesCalculator.calculateDailyCalories(70, 170, 30, 3);

        assertTrue(veryActiveCalories > sedentaryCalories);
    }

    @Test
    public void testCalculateDailyCalories_minimumValues() {
        double calories = CaloriesCalculator.calculateDailyCalories(40, 140, 70, 0);

        assertTrue(calories > 0);
        assertTrue(calories < 2000);
    }

    @Test
    public void testCalculateDailyCalories_maximumValues() {
        double calories = CaloriesCalculator.calculateDailyCalories(150, 210, 20, 3);

        assertTrue(calories > 0);
        assertTrue(calories > 3000);
    }
}
