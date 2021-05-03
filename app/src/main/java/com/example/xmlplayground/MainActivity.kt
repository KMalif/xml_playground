package com.example.xmlplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.xmlplayground.databinding.ActivityMainBinding
import com.example.xmlplayground.webservice.Constant

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logout()
    }


    private fun logout(){
        binding.IcToggle.setOnClickListener {
            Constant.clearToken(this)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}