package com.decagon.week6task

import android.widget.EditText
import org.junit.Test

import org.junit.Assert.*

class ValidateInputsTest {
    /*
     * Unit Test for valid Nigerian phone number
     */
    @Test
    fun getValidatedStatus_valid_returnTrue() {

        //create user number input
        val number = "+2348135081549"

        //Call function
        val obj = ValidateInputs()
        val result = obj.validateNumber(number)

        //Check result
        assertEquals(result, true)
    }


    /*
     * Unit Test for invalid Nigerian phone number
     */

    @Test
    fun getValidatedStatus_invalid_returnFalse() {
        //create user wrong number input
        val number = "+181350815490"

        //Call function
        val obj = ValidateInputs()
        val result = obj.validateNumber(number)

        //Check result
        assertEquals(result, false)
    }


    /*
     * Unit Test for empty input
     */
    @Test
    fun getValidatedStatus_empty_returnFalse() {
        //create empty user input
        val number = ""

        //Call function
        val obj = ValidateInputs()
        val result = obj.validateNumber(number)

        //Check result
        assertEquals(result, false)
    }
}