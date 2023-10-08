package com.example.newsfeed

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.textservice.TextInfo
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val TextInputEditText_username = findViewById<TextInputEditText>(R.id.login_name_input)
        val TextInputEditText_mes_id = findViewById<TextInputEditText>(R.id.login_mesid_input)
        val TextInputEditText_number = findViewById<TextInputEditText>(R.id.login_number_input)
        val TextInputEditText_password = findViewById<TextInputEditText>(R.id.login_password_input)
        val TextInputEditText_confirm_passrord = findViewById<TextInputEditText>(R.id.login_confirmpassword_input)

        val TextInputEditText_confirm_password_layout = findViewById<TextInputLayout>(R.id.textField5)

        //this code is for green border and red border on match and unmatch passwords
        TextInputEditText_confirm_passrord.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//              this mehtod is called before text changed
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                method is called when text is changing
                if (TextInputEditText_password.text.toString()==TextInputEditText_confirm_passrord.text.toString()){
                    TextInputEditText_confirm_password_layout.boxStrokeColor = ContextCompat.getColor(applicationContext, R.color.green) //this line changing the stroke color
//                    TextInputEditText_confirm_password_layout.setBoxBackgroundColorResource(R.color.green)
//                    TextInputEditText_confirm_password_layout.error = null // this will clear all previous error when changing password
                }else{
                    TextInputEditText_confirm_password_layout.boxStrokeColor = ContextCompat.getColor(applicationContext, R.color.red) //changing box stroke color
//                    TextInputEditText_confirm_password_layout.setBoxBackgroundColorResource(R.color.red)
//                    TextInputEditText_confirm_password_layout.error = "does not match"
                }
            }

            override fun afterTextChanged(p0: Editable?) {
//                this method called after text is changed
            }
        })


        val signup_button = findViewById<Button>(R.id.signup_button)
        // when i press enter then my cursor should move on next input field
        TextInputEditText_username.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                TextInputEditText_mes_id.requestFocus() // Move to the next EditText field
                true
            } else {
                false
            }
        }

        TextInputEditText_mes_id.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                TextInputEditText_number.requestFocus()
                // Handle any action specific to this field if needed
                true
            } else {
                false
            }
        }
        TextInputEditText_number.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                TextInputEditText_password.requestFocus() // Move to the next EditText field
                true
            } else {
                false
            }
        }
        TextInputEditText_password.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                TextInputEditText_confirm_passrord.requestFocus() // Move to the next EditText field
                true
            } else {
                false
            }
        }
        TextInputEditText_confirm_passrord.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                 // performing a click on the id name signup_button button
                signup_button.performClick();
                true
            } else {
                false
            }
        }



        signup_button.setOnClickListener(){
            var email_ready = false;
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(TextInputEditText_mes_id.text.toString()).matches()){
                TextInputEditText_mes_id.error = "please enter the valid email id."
            }else{
                email_ready = true;
            }

            var user_name = false;
            if(TextInputEditText_username.text.toString().equals("")){
                TextInputEditText_username.error = "user-name required"
            }else{
                user_name = true;
            }

            var number_ready = false;
            if (TextInputEditText_number.text.toString() == ""){
                TextInputEditText_number.error = "Number required"
            }else{
                number_ready = true;
            }

            var password_ready = false
            if (TextInputEditText_password.text.toString() == ""){
                TextInputEditText_password.error = "Password required"
            }else{
                password_ready = true;
            }


            // now check the confirm password matches or not
            var check_passwordMatch_ready = check_password_match(TextInputEditText_password.text.toString() ,TextInputEditText_confirm_passrord.text.toString())
        
            var form_ready = false
            if ((email_ready&&user_name&&number_ready&&password_ready&&check_passwordMatch_ready)){
                form_ready = true
            }
            
            // if form is complete then open new activity that displays the account is created
            if(form_ready){
                // write your intent here
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
                Toast.makeText(this, "account created created", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun check_password_match(password: String, reentredPassword: String): Boolean{

        return password == reentredPassword

    }

}