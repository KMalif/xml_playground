package com.example.xmlplayground.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xmlplayground.R
import com.example.xmlplayground.databinding.FragmentUserBinding
import com.example.xmlplayground.webservice.Constant

class UserFragment : Fragment() {
    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(layoutInflater)
        getName()
        return binding.root
    }

    private fun getName(){
        val name = Constant.getName(activity!!)
        binding.UserName.text = name
    }
}