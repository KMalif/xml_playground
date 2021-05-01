package com.example.xmlplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.xmlplayground.adapter.ViewPagerAdapter
import com.example.xmlplayground.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager(){
        val loginViewPager = ViewPagerAdapter(supportFragmentManager)
        binding.ViewPager.adapter = loginViewPager
        binding.TabLayout.setupWithViewPager(binding.ViewPager)
    }
}