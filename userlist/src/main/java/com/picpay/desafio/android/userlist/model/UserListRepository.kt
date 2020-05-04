package com.picpay.desafio.android.userlist.model

import com.picpay.desafio.android.data.db.PicPayDatabase
import com.picpay.desafio.android.data.db.UserListDao
import com.picpay.desafio.android.features.contacts.api.response.UserListResponse
import com.picpay.desafio.android.features.contacts.api.service.UserListService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

class UserListRepository @Inject constructor(
    private val service: UserListService,
    private val userListDao: UserListDao,
    private val payDatabase: PicPayDatabase
) {
    suspend fun getUserList(): MutableList<UserListResponse> {
        return withContext(Dispatchers.IO) {
            if (hasToFetchDataFromService(ZonedDateTime.now())) {
                val userList: MutableList<UserListResponse> = service.getUserList()
                payDatabase.userListDao().update(userList)
                userList
            } else {
                userListDao.getUserList()
            }
        }
    }

    private fun hasToFetchDataFromService(lastFetchTime: ZonedDateTime): Boolean {
        val oneHourAgo = ZonedDateTime.now().minusHours(1)
        return if (oneHourAgo != null) lastFetchTime.isBefore(oneHourAgo)
        else false
    }
}