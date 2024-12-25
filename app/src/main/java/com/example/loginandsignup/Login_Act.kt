package com.example.loginandsignup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginandsignup.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login_Act : AppCompatActivity() {
    private  lateinit var   binding: ActivityLoginBinding
    private  lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding  =  ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

         firebaseAuth  = FirebaseAuth.getInstance()
        binding.loginLoginBtn.setOnClickListener {
              val email  =  binding.loginEmailId.text.toString()
              val password =  binding.loginPasswordId.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty())  {
                  firebaseAuth.signInWithEmailAndPassword(email ,  password)
                      .addOnCompleteListener(this){task ->
                            if (task.isSuccessful){
                                  Toast.makeText(this ,  "Login Successful" ,  Toast.LENGTH_SHORT).show()
                                val intent =  Intent(this  ,  MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this ,  "Login Failed" ,  Toast.LENGTH_SHORT).show()
                            }
                      }
            } else  {
                  Toast.makeText(this ,"Please Input Email  And Password" ,Toast.LENGTH_SHORT).show()
            }

        }

    }
}