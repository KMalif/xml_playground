package com.example.xmlplayground.model

data class User (
        var id_users: Int,
        var username: String,
        var email: String,
        var password:String,
        var books : List<Book>,
        var token : String
)