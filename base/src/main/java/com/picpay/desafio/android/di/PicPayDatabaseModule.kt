package com.picpay.desafio.android.di

import com.picpay.desafio.android.PicPayApp
import com.picpay.desafio.android.data.db.PicPayDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class PicPayDatabaseModule {

    @Provides
    @Reusable
    fun providePicaPayDatabase(app: PicPayApp): PicPayDatabase {
        return PicPayDatabase.invoke(app.applicationContext)
    }
}