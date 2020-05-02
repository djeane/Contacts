package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.ApplicationComponent
import com.picpay.desafio.android.di.DaggerApplicationComponent
import com.picpay.desafio.android.di.FeatureComponent
import javax.inject.Inject

open class PicPayApp : Application() {

    @Inject
    lateinit var applicationComponent: ApplicationComponent

    var featureComponents = mutableMapOf<String, FeatureComponent>()

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .buildPicPayApplication(this)
            .build().also {
                it.injectMembers(this)
            }
    }

    inline fun <reified T : FeatureComponent> getOrPutComponent(component: () -> T): T {
        return featureComponents.getOrPut(T::class.java.name, component) as T
    }
}