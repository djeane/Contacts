package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.ApplicationComponent
import com.picpay.desafio.android.di.DaggerApplicationComponent
import javax.inject.Inject

class PicPayApp : Application() {

    @Inject
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .buildPicPayApplication(this)
            .build().also {
                it.injectMembers(this)
            }
    }

    companion object {
        fun getInstance() = this
    }
}