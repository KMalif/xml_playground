package com.example.xmlplayground.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.xmlplayground.MainActivity
import com.example.xmlplayground.R
import com.example.xmlplayground.databinding.FragmentLoginBinding
import com.example.xmlplayground.model.User
import com.example.xmlplayground.webservice.APIClient
import com.example.xmlplayground.webservice.Constant
import com.example.xmlplayground.webservice.SingleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isLogin()
        onBtnLoginAction()
    }

    private fun isLogin(){
        val token = Constant.getToken(activity!!)
        if (!token.equals("UNDEFINED")){
            startActivity(Intent(activity, MainActivity::class.java).also {
                activity!!.finish()
            })
            println("Current Token $token")
        }

    }

    private fun onBtnLoginAction(){
        binding.BtnLogin.setOnClickListener {
            doLogin()
        }

    }

    private fun doLogin(){
        val email = binding.ETEmail.text.toString()
        val password = binding.EtPassword.text.toString()

        APIClient.APIEndpoint().login(email, password).enqueue(object :
            Callback<SingleResponse<User>>{
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
                        Constant.setToken(activity!!, body.data.token)
                        Toast.makeText(activity, "Hi ${body.data.username}", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(activity, "Failed to Login, please check your email or password", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(activity, "Try Again Later", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}