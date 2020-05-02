package com.picpay.desafio.android.contacts.di

import androidx.appcompat.app.AppCompatActivity
import com.picpay.desafio.android.contacts.ui.activities.ContactsActivity
import dagger.Module
import dagger.Provides

@Module
class ContactsModule {

    @Provides
    fun providesActivity(activity: ContactsActivity): AppCompatActivity {
        return activity
    }
}
