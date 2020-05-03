package com.picpay.desafio.android.userlist.di

import com.picpay.desafio.android.userlist.ui.activities.UserListActivity
import com.picpay.desafio.android.di.ApplicationComponent
import com.picpay.desafio.android.di.FeatureComponent
import com.picpay.desafio.android.di.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [UserListModule::class]
)
interface UserListComponent : FeatureComponent {
    fun inject(activity: UserListActivity)
}