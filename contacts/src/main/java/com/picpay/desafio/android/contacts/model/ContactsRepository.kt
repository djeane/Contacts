package com.picpay.desafio.android.contacts.model

import com.picpay.desafio.android.arch.RepositoryResult
import com.picpay.desafio.android.features.contacts.api.response.ContactsResponse
import com.picpay.desafio.android.features.contacts.api.service.ContactsService
import retrofit2.Call
import javax.inject.Inject

class ContactsRepository @Inject constructor(
    private val service: ContactsService
) {
    suspend fun getContacts(): List<ContactsResponse> =
        service.getContacts().toList()
}