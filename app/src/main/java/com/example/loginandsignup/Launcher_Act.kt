package com.example.loginandsignup

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginandsignup.databinding.ActivityLauncherBinding

class Launcher_Act : AppCompatActivity() {
    private  lateinit var  binding: ActivityLauncherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =  ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginBtn.setOnClickListener {
            val intent =  Intent(this ,  Login_Act::class.java)
            startActivity(intent)
        }

        binding.registerBtn.setOnClickListener {
            val intent  =  Intent(this  , Register_Act::class.java)
            startActivity(intent)
        }


    }
}