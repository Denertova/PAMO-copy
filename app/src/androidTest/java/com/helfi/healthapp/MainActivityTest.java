package com.helfi.healthapp;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Before
    public void setUp() {
        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void testStartButtonIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.btnStart))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testClickStartButtonNavigatesToMenuActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.btnStart))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.btnBMI))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testStartButtonIsClickable() {
        Espresso.onView(ViewMatchers.withId(R.id.btnStart))
                .check(ViewAssertions.matches(ViewMatchers.isClickable()));
    }
}
