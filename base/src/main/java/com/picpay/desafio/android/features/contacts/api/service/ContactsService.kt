package com.picpay.desafio.android.features.contacts.api.service

import com.picpay.desafio.android.arch.RepositoryResult
import com.picpay.desafio.android.features.contacts.api.response.ContactsResponse
import retrofit2.http.GET


interface ContactsService {

    @GET("users")
    suspend fun getContacts(): List<ContactsResponse>
}