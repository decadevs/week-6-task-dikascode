package com.decagon.week6task

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.provider.ContactsContract.Directory.PACKAGE_NAME
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


//Declare constants
const val NAME_TYPED = "Darrot Cole"
const val VALID_NUMBER_TYPED = "08145367234"
const val EMAIL_TYPED = "dika@gmail.com"
const val INVALID_EMAIL_TYPED = "dika.gmail.com"
const val INVALID_NUMBER_TYPED = "081453672341"
val INVALID_NUMBER2_TYPED = "+2358145367234"


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    /*
     *Launch MainActivity once for all test methods
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun test_isActivityInView() {

        //Test if Main activity layout is inflated and displayed
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }


    /*
       * Test EditText input Views are visible
      */
    @Test
    fun test_editTextView_visibility() {
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
    fun test_buttonViewButtonText_visibility() {

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

    @Test
    fun test_registerTextView_visibility() {

        //Register TextView visibility test
        onView(withId(R.id.tv_register)).check(matches(isDisplayed()))
    }



        /*
     * Hint test for all EditText views in MainActivity
    */
    @Test
    fun test_editTextViewsHint_visibility() {
        onView(withId(R.id.et_name)).check(matches(withHint(R.string.et_name_hint)))
        onView(withId(R.id.et_email)).check(matches(withHint(R.string.et_email_hint)))
        onView(withId(R.id.et_number)).check(matches(withHint(R.string.et_number_hint)))
    }


    /*
    * Error test for name field empty
    */
    @Test
    fun test_registerClicked_whenNameEditTextEmpty_shouldShowError() {
        //Simulate input for email and number EditText Views
        onView(withId(R.id.et_email)).perform(typeText(EMAIL_TYPED)).perform(closeSoftKeyboard())
        onView(withId(R.id.et_number)).perform(typeText(VALID_NUMBER_TYPED))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.et_name)).check((matches(hasErrorText("Name Field can't be empty"))))
    }


    /*
    * Error test for email field empty
    */
    @Test
    fun test_registerClicked_whenEmailEditTextEmpty_shouldShowError() {
        //Simulate input for name and number EditText Views
        onView(withId(R.id.et_name)).perform(typeText(NAME_TYPED)).perform(closeSoftKeyboard())
        onView(withId(R.id.et_number)).perform(typeText(VALID_NUMBER_TYPED))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.et_email)).check((matches(hasErrorText("Email Field cannot be empty"))))
    }


    /*
    * Error test for number field empty
    */
    @Test
    fun test_registerClicked_whenNumberEditTextEmpty_shouldShowError() {
        //Simulate input for name and email EditText Views
        nameTypedEmailTyped()
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.et_number)).check((matches(hasErrorText("Phone field cannot be empty"))))
    }

    @Test
    fun test_registerClicked_whenNumberIsInvalid_shouldShowError() {
        //Simulate input for invalid number, name and email EditText Views
        nameTypedEmailTyped()
        onView(withId(R.id.et_number)).perform(typeText(INVALID_NUMBER_TYPED))
            .perform(closeSoftKeyboard())
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.et_number)).check((matches(hasErrorText("Please input a correct Nigerian number"))))
    }

    @Test
    fun test_registerClicked_whenEmailIsInvalid_shouldShowError() {
        //Simulate input for number, name and invalid email EditText Views
        onView(withId(R.id.et_name)).perform(typeText(NAME_TYPED)).perform(closeSoftKeyboard())
        onView(withId(R.id.et_email)).perform(typeText(INVALID_EMAIL_TYPED))
            .perform(closeSoftKeyboard())
        onView(withId(R.id.et_number)).perform(typeText(VALID_NUMBER_TYPED))
            .perform(closeSoftKeyboard())

        //Auto click register button
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.et_email)).check(matches(hasErrorText("Please enter a valid email address")))
    }


    @Before
    fun stub_SetUp() {
        val intent = Intent()

        intent.putExtra("Name", NAME_TYPED)
        intent.putExtra("Email", EMAIL_TYPED)
        intent.putExtra("Number", VALID_NUMBER_TYPED)
        intent.putExtra("Gender", "Male")
    }

    /*
     * Set rule for Intent destination activity
     */
    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun validateIntentSentToPackage() {
        //Simulate inputs
        nameTypedEmailTyped()
        onView(withId(R.id.et_number)).perform(typeText(VALID_NUMBER_TYPED))
            .perform(closeSoftKeyboard())


        //Auto select spinner value
        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("Male")))
            .perform(click())

        onView(withId(R.id.button)).perform(click())

//        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, intent)


        /* setup result stubbing**/
        intended(hasComponent(UserProfile::class.java.name))

        //Check if intents are passed correctly
        onView(withId(R.id.tv_name)).check(matches(withText(NAME_TYPED)))
        onView(withId(R.id.tv_email)).check(matches(withText("Email: $EMAIL_TYPED")))
        onView(withId(R.id.tv_number)).check(matches(withText("Phone: $VALID_NUMBER_TYPED")))
        onView(withId(R.id.tv_gender)).check(matches(withText("Gender: Male")))

    }

    private fun nameTypedEmailTyped() {
        onView(withId(R.id.et_name)).perform(typeText(NAME_TYPED)).perform(closeSoftKeyboard())
        onView(withId(R.id.et_email)).perform(typeText(EMAIL_TYPED)).perform(closeSoftKeyboard())
    }
}