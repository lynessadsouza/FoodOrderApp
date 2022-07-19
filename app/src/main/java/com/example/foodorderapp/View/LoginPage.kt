package com.example.foodorderapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.foodorderapp.R
import com.example.foodorderapp.ViewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {
    private var loginRegisterViewModel: LoginViewModel? = null
    var email: String = ""
    var password: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        loginRegisterViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginButton.setOnClickListener {
            email = emailEdittext.text.toString().trim()
            password = password_edit_text.text.toString()
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                //invalid email format
                emailEdittext.error = "Invalid Email Format"
            } else if (TextUtils.isEmpty(password)) {
                //no password
                passwordTextview.error = "Please enter password"
            } else {
                loginRegisterViewModel?.login(email, password)

            }
        }

        loginRegisterViewModel?.isLoginSuccessful?.observe(this) { success ->
            if (success) {
                OnSuccessfulLogin()
            } else {
                Toast.makeText(
                    this,
                    "Login Failed!!! Please Enter correct details ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        loginRegisterViewModel?.role?.observe(this) { success ->
            if (success) {
                Log.d("hey","hey manager")
            } else {
                Log.d("hey","hey server")
            }
        }

    }

    private fun OnSuccessfulLogin() {
        Log.d("hey","hey")
    }
}
