package com.picpay.desafio.android.features.user.api.service

import com.picpay.desafio.android.features.user.api.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET


interface UserService {

    @GET("users")
    fun getUsers(): Call<List<UserResponse>>
}