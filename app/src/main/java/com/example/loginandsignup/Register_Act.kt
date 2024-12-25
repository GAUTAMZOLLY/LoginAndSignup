package com.example.loginandsignup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginandsignup.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register_Act : AppCompatActivity() {
    private  lateinit var   binding: ActivityRegisterBinding
//    firebase Auth
    private  lateinit var   firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  =  ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth =  FirebaseAuth.getInstance()
        binding.RegisterRegisterBtn.setOnClickListener {
              val name =  binding.nameId.text.toString()
             val number =  binding.numberId.text.toString()
             val email =  binding.registerEmailId.text.toString()
             val password =  binding.registerEmailId.text.toString()
            if (name.isNotEmpty() &&  number.isNotEmpty() &&  email.isNotEmpty() &&  password.isNotEmpty())  {
                  firebaseAuth.createUserWithEmailAndPassword(email  ,  password)
                      .addOnCompleteListener(this) {task ->
                            if (task.isSuccessful){
                                  Toast.makeText(this ,  "Signup Successful" ,Toast.LENGTH_SHORT).show()
                                val intent =  Intent(this  ,  Login_Act::class.java)
                                 startActivity(intent)
                                finish()
                            }  else  {
                                  Toast.makeText(this  ,  "signIn Unsuccessful" ,Toast.LENGTH_SHORT).show()
                            }
                      }
            } else  {
                  Toast.makeText(this  ,  "Enter Email  And Password" ,Toast.LENGTH_SHORT).show()
            }
        }
    }
}