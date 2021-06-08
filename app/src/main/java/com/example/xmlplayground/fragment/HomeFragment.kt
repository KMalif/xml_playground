package com.example.xmlplayground.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xmlplayground.FooddetailActivity
import com.example.xmlplayground.R
import com.example.xmlplayground.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        toDetailFood()
        return binding.root
    }

    private fun toDetailFood(){
        binding.TVSeeMore.setOnClickListener {
            startActivity(Intent(activity, FooddetailActivity::class.java))
        }
    }

}