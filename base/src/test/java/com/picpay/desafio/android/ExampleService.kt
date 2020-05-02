package com.picpay.desafio.android

import com.picpay.desafio.android.features.user.api.service.UserService
import com.picpay.desafio.android.features.user.api.response.UserResponse

class ExampleService(
    private val service: UserService
) {

    fun example(): List<UserResponse> {
        val users = service.getUsers().execute()

        return users.body() ?: emptyList()
    }
}