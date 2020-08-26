package com.decagon.week6task
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    /*
     *Launch MainActivity once for all test methods
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isActivityInView() {

        /*
          * Test if Main activity layout is inflated and displayed
         */
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }


    /*
       * Test EditText input Views are visible
      */
    @Test
    fun test_editTextView_Visibility() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //Name EditText View
        onView(withId(R.id.et_name)).check(matches(isDisplayed()))

        //Email EditText View
        onView(withId(R.id.et_email)).check(matches(isDisplayed()))

        //Number EditText View
        onView(withId(R.id.et_number)).check(matches(isDisplayed()))

        //Spinner
        onView(withId(R.id.spinner)).check(matches(isDisplayed()))
//        onView(withId(R.id.spinner)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }


    /*
      * Test for Button view and Button text visibility
     */
    @Test
    fun test_buttonViewButtonText_Visibility() {

        //Button View in main activity
        onView(withId(R.id.button)).check(matches(isDisplayed()))

        //Button text
        onView(withId(R.id.button)).check(matches(withText(R.string.button_text)))
    }


    /*
      * MainActivity image visibility
     */
    @Test
    fun test_mainActivityImage_visibility() {

        //ImageView View in main activity
        onView(withId(R.id.reg_image)).check(matches(isDisplayed()))
    }


}