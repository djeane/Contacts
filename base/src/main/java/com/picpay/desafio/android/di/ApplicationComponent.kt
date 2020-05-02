package com.picpay.desafio.android.di

import com.picpay.desafio.android.PicPayApp
import com.picpay.desafio.android.base.BaseActivity
import com.picpay.desafio.android.features.user.api.service.UserService
import dagger.BindsInstance
import dagger.Component
import dagger.MembersInjector
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PickPayAppScope

@PickPayAppScope
@Component(modules = [RetrofitModule::class])

interface ApplicationComponent : MembersInjector<PicPayApp> {

    //val userService: UserService

    fun inject(activity: BaseActivity)

    @Named(RetrofitModule.GENERAL_RETROFIT)
    fun getGeneralRetrofit(): Retrofit

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildPicPayApplication(app: PicPayApp): Builder

        fun build(): ApplicationComponent
    }
}