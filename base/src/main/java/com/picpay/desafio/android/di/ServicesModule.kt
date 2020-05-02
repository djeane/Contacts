package com.picpay.desafio.android.di

import com.picpay.desafio.android.features.contacts.api.service.ContactsService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import javax.inject.Named


class ServicesModule {

    /*@Provides
    @Reusable
    fun provideContactsService(@Named(RetrofitModule.GENERAL_RETROFIT)retrofit: Retrofit): ContactsService {
        return retrofit.create(ContactsService::class.java)
    }*/

    /*@Reusable
    @Provides
    fun providesCardServices(@Named(RetrofitModule.AES) retrofit: Retrofit): CardServices {
        return retrofit.create(CardServices::class.java)
    }*/
}