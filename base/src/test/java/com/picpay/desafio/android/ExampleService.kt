package com.picpay.desafio.android

import com.picpay.desafio.android.features.contacts.api.service.UserListService
import com.picpay.desafio.android.features.contacts.api.response.UserListResponse

class ExampleService(
    private val service: UserListService
) {

    fun example(): List<UserListResponse> {
        val users = service.getUserList().execute()

        return users.body() ?: emptyList()
    }
}