package com.picpay.desafio.android.di

import com.picpay.desafio.android.PicPayApp
import com.picpay.desafio.android.base.BaseActivity
import com.picpay.desafio.android.features.contacts.api.service.UserListService
import dagger.BindsInstance
import dagger.Component
import dagger.MembersInjector
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PicPayAppScope

@PicPayAppScope
@Component(
    modules = [
        ServicesModule::class,
        RetrofitModule::class,
        PicPayDatabaseModule::class
    ]
)
interface ApplicationComponent : MembersInjector<PicPayApp> {

    val contactsService: UserListService
    val app: PicPayApp

    @Named(RetrofitModule.GENERAL_RETROFIT)
    fun provideGeneralRetrofit(): Retrofit

    fun inject(activity: BaseActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: PicPayApp): Builder

        fun build(): ApplicationComponent
    }
}