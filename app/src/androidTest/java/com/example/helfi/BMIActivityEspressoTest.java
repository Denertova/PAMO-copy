package com.example.helfi;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BMIActivityEspressoTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void calculateBmiDisplaysResult() {
        onView(withId(R.id.btnStart)).perform(click());
        onView(withId(R.id.btnBMI)).perform(click());
        onView(withId(R.id.weight)).perform(typeText("60"), closeSoftKeyboard());
        onView(withId(R.id.height)).perform(typeText("170"), closeSoftKeyboard());
        onView(withId(R.id.calculate)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(containsString("BMI:"))));
    }
}
