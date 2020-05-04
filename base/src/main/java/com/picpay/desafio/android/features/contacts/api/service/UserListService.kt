package com.picpay.desafio.android.features.contacts.api.service

import com.picpay.desafio.android.features.contacts.api.response.UserListResponse
import retrofit2.http.GET


interface UserListService {

    @GET("users")
    suspend fun getUserList(): ArrayList<UserListResponse>
}