package com.decagon.week6task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserProfile : AppCompatActivity() {
    /*
     * Declare global variables for User activity
     */
    lateinit var textViewName: TextView
    lateinit var textViewEmail: TextView
    lateinit var textViewNumber: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        //Display user information method
        displayUserData()
    }

    private fun displayUserData() {
        //get data from intent
        val intent = intent
        val name = intent.getStringExtra("Name")
        val email = intent.getStringExtra("Email")
        val phone = intent.getStringExtra("Phone")

        //Assign corresponding View Id's
        textViewName = findViewById(R.id.tv_name)
        textViewEmail = findViewById(R.id.tv_email)
        textViewNumber = findViewById(R.id.tv_number)


        //Assign data to TextViews
        textViewName.text = "Name: $name"
        textViewEmail.text = "Email: $email"
        textViewNumber.text = "Phone Number: $phone"
    }
}