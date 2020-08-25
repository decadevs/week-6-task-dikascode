package com.decagon.week6task

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class UserProfileTest {
    /*
     *Launch UserProfile activity activity once
     */

    @get:Rule
    val activityRule = ActivityScenarioRule(UserProfile::class.java)

    @Test
    fun test_isActivity_visible() {
        /*
         * Test if UserProfile layout is inflated and displayed
        */
        onView(ViewMatchers.withId(R.id.user_profile))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    /*
     * Visibility test for profile ImageView visibility
     */
    @Test
    fun test_userProfileImageView_visibility() {
        //Image view in UserProfile activity
        onView(ViewMatchers.withId(R.id.profile_bg))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    /*
     * Visibility test for TextViews in UserProfile activity
     */
    @Test
    fun test_userProfileTextViews_visibility() {

        //Name TextView
        onView(ViewMatchers.withId(R.id.tv_name))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        //Email TextView
        onView(ViewMatchers.withId(R.id.tv_email))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        //Email TextView
        onView(ViewMatchers.withId(R.id.tv_number))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        //Gender TextView
        onView(ViewMatchers.withId(R.id.tv_gender))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}