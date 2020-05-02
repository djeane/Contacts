package com.picpay.desafio.android.contacts.di

import com.picpay.desafio.android.contacts.ui.activities.ContactsActivity
import com.picpay.desafio.android.di.ApplicationComponent
import com.picpay.desafio.android.di.FeatureComponent
import com.picpay.desafio.android.di.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ContactsModule::class]
)
interface ContactsComponent : FeatureComponent {
    fun inject(activity: ContactsActivity)
}