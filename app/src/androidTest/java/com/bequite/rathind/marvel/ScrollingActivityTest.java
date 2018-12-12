package com.bequite.rathind.marvel;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class ScrollingActivityTest {
    @RunWith(AndroidJUnit4.class)
    public class ScrollActivityBasicTest{

        @Rule public ActivityTestRule<ScrollingActivity> mScrolling = new ActivityTestRule<>(ScrollingActivity.class);

        @Test
        public void pricetextViewTest(){
//            Find PriceTextView
//            check the textview
            onView(withId(R.id.priceTxt)).check(matches(withText("Buy now:")));

        }
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() {
    }
}