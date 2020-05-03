package com.picpay.desafio.android.userlist.model

import com.picpay.desafio.android.features.contacts.api.response.UserListResponse
import com.picpay.desafio.android.features.contacts.api.service.UserListService
import javax.inject.Inject

class UserListRepository @Inject constructor(
    private val service: UserListService
) {
    suspend fun getUserList(): List<UserListResponse> = service.getUserList().toList()
}