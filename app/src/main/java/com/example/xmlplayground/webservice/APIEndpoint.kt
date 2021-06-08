package com.example.xmlplayground.webservice

import com.example.xmlplayground.model.Book
import com.example.xmlplayground.model.User
import retrofit2.Call
import retrofit2.http.*

interface APIEndpoint {

    @FormUrlEncoded
    @POST("auth/sign-up")
    fun register (
        @Field("name") name : String,
        @Field("username")username : String,
        @Field("email")email : String,
        @Field("password")password : String): Call<SingleResponse<User>>

    @FormUrlEncoded
    @POST("auth/sign-in")
    fun login(
        @Field("username") username: String,
        @Field("password")password: String
    ): Call<SingleResponse<User>>

    @GET("books")
    fun getAllBooks(@Header("x-access-token")token : String):Call<ListResponse<Book>>

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