package com.example.xmlplayground.webservice

import com.example.xmlplayground.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIEndpoint {

    @FormUrlEncoded
    @POST("auth/sign-up")
    fun register (
        @Field("username")username : String,
        @Field("email")email : String,
        @Field("password")password : String): Call<SingleResponse<User>>

    @FormUrlEncoded
    @POST("auth/sign-in")
    fun login(
        @Field("email") email: String,
        @Field("password")password: String
    ): Call<SingleResponse<User>>

}

data class ListResponse<T>(
    var message : String,
    var status : Int,
    var data : List<T>
)

data class SingleResponse<T>(
    var message : String,
    var status : Int,
    var data : T
)