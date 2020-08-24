package com.decagon.week6task

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    /*
     * Declare global variables
     */

    lateinit var editTextName: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextNumber: EditText
    lateinit var genderOption: Spinner
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button.setOnClickListener {
            validateName()
            validateEmail()
            validateNumber()
        }

    }

    /*
     * Validate name field
     */
    private fun validateName(): Boolean {
        /*
         * Initialize Name EditText field
         */
        editTextName = findViewById(R.id.et_name)
        var nameInput = editTextName.text.trim()

        /*
         * Replace white spaces between string with single space
         */
        nameInput = nameInput.replace("\\s+".toRegex(), " ")

        return if (nameInput.isEmpty()) {
            Toast.makeText(this, "Name field cannot be empty", Toast.LENGTH_SHORT).show()
            editTextName.error = "Name Field can't be empty"
            false
        } else {
            Toast.makeText(this, "$nameInput", Toast.LENGTH_SHORT).show()
            editTextName.error = null
            true
        }

    }


    /*
     * Validate Email input
     */

    private fun validateEmail(): Boolean {
        /*
        * Initialize Email EditText field
        */
        editTextEmail = findViewById(R.id.et_email)
        val emailInput = editTextEmail.text.trim()

        return if (emailInput.isEmpty()) {
            Toast.makeText(this, "This field cannot be empty", Toast.LENGTH_SHORT).show()
            editTextEmail.error = "Email Field cannot be empty"
            false

            //Check if the email input is valid using regular expressions
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
            editTextEmail.error = "Please enter a valid email address"
            false
        } else {
            editTextEmail.error = null
            true
        }
    }


    private fun validateNumber(): Boolean {
        //Assign view id
        editTextNumber = findViewById(R.id.et_number)

        /*
         * Validate Nigerian phone number to match
         * starting with +234 or 0 and completed with 10 digits
         * using regex
         */

        val numberInput = editTextNumber.text.trim().replace("\\s+".toRegex(), "")
        val regexPhonePattern = "^(\\+?234|0)\\d{10}\$".toRegex()
        val validation = numberInput.matches(regexPhonePattern)

        return if (numberInput.isEmpty()) {
            editTextNumber.error = "Phone field cannot be empty"
            false
        } else if (!validation) {
            editTextNumber.error = "Please input a correct Nigerian number"
            false
        } else {
            true
        }
    }


}