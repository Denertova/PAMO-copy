package com.example.helfi;

import org.junit.Test;
import static org.junit.Assert.*;

public class HealthCalculatorTest {

    @Test
    public void calculateBmi_isCorrect() {
        double weight = 70;
        double height = 175;
        double expected = 70 / (1.75 * 1.75);
        assertEquals(expected, HealthCalculator.calculateBmi(weight, height), 0.01);
    }

    @Test
    public void bmiCategory_isCorrect() {
        assertEquals("Niedowaga", HealthCalculator.bmiCategory(18.0));
        assertEquals("Waga prawidłowa", HealthCalculator.bmiCategory(22.0));
        assertEquals("Nadwaga", HealthCalculator.bmiCategory(27.0));
        assertEquals("Otyłość", HealthCalculator.bmiCategory(32.0));
    }
}
