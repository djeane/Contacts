package com.picpay.desafio.android

import com.picpay.desafio.android.features.contacts.api.service.ContactsService
import com.picpay.desafio.android.features.contacts.api.response.ContactsResponse

class ExampleService(
    private val service: ContactsService
) {

    fun example(): List<ContactsResponse> {
        val users = service.getUsers().execute()

        return users.body() ?: emptyList()
    }
}