package com.example.xmlplayground.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.xmlplayground.R
import com.example.xmlplayground.databinding.FragmentLoginBinding
import com.example.xmlplayground.databinding.FragmentRegisterBinding
import com.example.xmlplayground.model.User
import com.example.xmlplayground.webservice.APIClient
import com.example.xmlplayground.webservice.SingleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBtnRegisterAction()
    }

    private fun onBtnRegisterAction(){
        binding.BtnRegister.setOnClickListener {
            doRegister()
        }
    }

    private fun doRegister(){
        val username = binding.ETName.text.toString()
        val email = binding.ETEmail.text.toString()
        val password = binding.EtPassword.text.toString()

        APIClient.APIEndpoint().register(username, email, password).enqueue(object : Callback<SingleResponse<User>>{
            override fun onFailure(call: Call<SingleResponse<User>>, t: Throwable) {
                println(t.message)
            }

            override fun onResponse(
                call: Call<SingleResponse<User>>,
                response: Response<SingleResponse<User>>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null){
                        resetForm()
                        Toast.makeText(activity, "Register Success", Toast.LENGTH_LONG).show()
                        Log.d("Register", "onResponse: ${body.data}")
                    }
                }else{
                    Toast.makeText(activity, "Try Again Later", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun resetForm(){
        binding.ETName.setText("")
        binding.ETEmail.setText("")
        binding.EtPassword.setText("")
    }
}