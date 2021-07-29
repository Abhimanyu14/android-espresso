package com.makeappssimple.abhimanyu.espresso.android

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // To test if activity is displayed
    @Test
    fun test_isActivityInView() {
        onView(withId(R.id.layout_activity_main)).check(matches(isDisplayed()))
    }

    // To test if activity views are displayed
    @Test
    fun test_visibilityOfTitleAndButton() {
        onView(withId(R.id.textview_activity_main_title)).check(matches(isDisplayed()))
        onView(withId(R.id.button_activity_main_switch_activity)).check(
            matches(
                withEffectiveVisibility(Visibility.VISIBLE)
            )
        )
    }

    // To test if activity views are displayed with correct data
    @Test
    fun test_isCorrectTitleDisplayed() {
        onView(withId(R.id.textview_activity_main_title)).check(matches(withText(R.string.activity_main_title)))
    }

    // To test navigation on button click
    @Test
    fun test_navigationToSecondActivity() {
        onView(withId(R.id.button_activity_main_switch_activity)).perform(ViewActions.click())
        onView(withId(R.id.layout_activity_second)).check(matches(isDisplayed()))

        pressBack()
        onView(withId(R.id.layout_activity_main)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
