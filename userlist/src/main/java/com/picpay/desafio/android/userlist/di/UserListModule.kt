package com.picpay.desafio.android.userlist.di

import androidx.appcompat.app.AppCompatActivity
import com.picpay.desafio.android.PicPayApp
import com.picpay.desafio.android.data.db.PicPayDatabase
import com.picpay.desafio.android.data.db.UserListDao
import com.picpay.desafio.android.userlist.ui.activities.UserListActivity
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class UserListModule {

    @Provides
    fun providesActivity(activity: UserListActivity): AppCompatActivity {
        return activity
    }

    @Provides
    fun providesUserListDao(picPayDatabase: PicPayDatabase): UserListDao {
        return picPayDatabase.userListDao()
    }

    @Provides
    @Reusable
    fun providePicaPayDatabase(app: PicPayApp): PicPayDatabase {
        return PicPayDatabase.invoke(app.applicationContext)
    }
}