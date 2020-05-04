package com.picpay.desafio.android.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.android.features.contacts.api.response.UserListResponse

@Dao
interface UserListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(userList: MutableList<UserListResponse>)

    @Query(SELECT_FROM_USER)
    fun getUserList(): MutableList<UserListResponse>

    companion object {
        const val SELECT_FROM_USER = "select * from users"
    }
}