package com.picpay.desafio.android.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class RetrofitModule {

    @Provides
    @Reusable
    @Named(GENERAL_RETROFIT)
    fun provideGeneralRetrofit(): Retrofit = getRetrofit()

    private fun getOkHttp(): OkHttpClient{
        val interceptor =  HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(getOkHttp())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    companion object {
        const val BASE_URL = "http://careers.picpay.com/tests/mobdev/"
        const val GENERAL_RETROFIT = "GENERAL_RETROFIT"
    }
}