package com.picpay.desafio.android.userlist.model

import com.picpay.desafio.android.data.db.PicPayDatabase
import com.picpay.desafio.android.data.db.UserListDao
import com.picpay.desafio.android.features.contacts.api.response.UserListResponse
import com.picpay.desafio.android.features.contacts.api.service.UserListService
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

class UserListRepository @Inject constructor(
    private val service: UserListService,
    private val userListDao: UserListDao,
    private val payDatabase: PicPayDatabase
) {
    suspend fun getUserList(): MutableList<UserListResponse> {
        return if (hasToFetchDataFromService(ZonedDateTime.now())) {
            userListDao.getUserList()
        } else {
            val userList: MutableList<UserListResponse> = service.getUserList()
            payDatabase.userListDao().update(userList)
            userList
        }
    }

    private fun hasToFetchDataFromService(lastFetchTime: ZonedDateTime): Boolean {
        val oneHourAgo = ZonedDateTime.now().minusHours(1)
        return lastFetchTime.isBefore(oneHourAgo)
    }
}