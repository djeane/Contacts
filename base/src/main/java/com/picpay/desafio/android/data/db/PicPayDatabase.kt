package com.picpay.desafio.android.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.picpay.desafio.android.features.contacts.api.response.UserListResponse

@Database(
    entities = [UserListResponse::class],
    version = 1
)
abstract class PicPayDatabase : RoomDatabase() {

    abstract fun userListDao(): UserListDao

    companion object {
        @Volatile
        private var instance: PicPayDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, PicPayDatabase::class.java, "picpay.db")
                .build()
    }
}