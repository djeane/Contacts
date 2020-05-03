package com.picpay.desafio.android.userlist.di

import androidx.appcompat.app.AppCompatActivity
import com.picpay.desafio.android.userlist.ui.activities.UserListActivity
import dagger.Module
import dagger.Provides

@Module
class UserListModule {

    @Provides
    fun providesActivity(activity: UserListActivity): AppCompatActivity {
        return activity
    }
}