package com.picpay.desafio.android.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class RetrofitModule {

    @Provides
    @Reusable
    @Named(GENERAL_RETROFIT)
    fun provideGeneralRetrofit(): Retrofit = getRetrofit()

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    companion object {
        private const val BASE_URL = "http://careers.picpay.com/tests/mobdev/"
        const val GENERAL_RETROFIT = "GENERAL_RETROFIT"
    }
}