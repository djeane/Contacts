package com.picpay.desafio.android.contacts.di

import com.picpay.desafio.android.di.FeatureScope
import com.picpay.desafio.android.di.RetrofitModule
import com.picpay.desafio.android.features.contacts.api.service.ContactsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class ContactsModule {

    @FeatureScope
    @Provides
    fun provideContactsService(@Named(RetrofitModule.GENERAL_RETROFIT) retrofit: Retrofit): ContactsService {
        return retrofit.create(ContactsService::class.java)
    }
}