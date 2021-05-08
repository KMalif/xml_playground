package com.example.xmlplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.xmlplayground.databinding.ActivityMainBinding
import com.example.xmlplayground.fragment.FavoriteFragment
import com.example.xmlplayground.fragment.HistoryFragment
import com.example.xmlplayground.fragment.HomeFragment
import com.example.xmlplayground.fragment.UserFragment
import com.example.xmlplayground.webservice.Constant

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logout()
        setCurrentFragment(HomeFragment())
        onBotomNavAction()
    }

    private fun onBotomNavAction(){
        binding.BottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.icHome ->setCurrentFragment(HomeFragment())
                R.id.icFav ->setCurrentFragment(FavoriteFragment())
                R.id.icAcount ->setCurrentFragment(UserFragment())
                R.id.icHistory ->setCurrentFragment(HistoryFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.Container, fragment).addToBackStack(null).commit()
    }

    private fun logout(){
        binding.IcToggle.setOnClickListener {
            Constant.clearToken(this)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}