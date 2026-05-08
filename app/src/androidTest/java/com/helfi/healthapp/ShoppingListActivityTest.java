package com.helfi.healthapp;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ShoppingListActivityTest {

    @Before
    public void setUp() {
        ActivityScenario.launch(ShoppingListActivity.class);
    }

    @Test
    public void testRecyclerViewIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.shopping_list_recyclerview))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testMenuButtonIsVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.btnMenuFromShoppingList))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testActivityLoadsSuccessfully() {
        Espresso.onView(ViewMatchers.withId(R.id.shopping_list_recyclerview))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
