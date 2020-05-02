package com.picpay.desafio.android.features.contacts.api.service

import com.picpay.desafio.android.features.contacts.api.response.ContactsResponse
import retrofit2.Call
import retrofit2.http.GET


interface ContactsService {

    @GET("users")
    fun getContacts(): Call<List<ContactsResponse>>
}