package com.mrjalal.testrecyclerviewsample;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jalal on 1/25/2018.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    @Test
    public void setUp() throws Exception {
        Espresso.onView(ViewMatchers.withId(R.id.rv)).perform(RecyclerViewActions.scrollToPosition(20));
    }

}