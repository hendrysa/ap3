package com.ap3.klinik.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST


class database {

    interface database {
        @GET("auth_login")
        fun get_login_status(username: String, password: String): Int

        @POST("auth_register")
        fun register_user(): Boolean
    }

    val retrofit = Retrofit.Builder()
        .baseUrl("https://android.ernasis.my.id/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(database::class.java)
}