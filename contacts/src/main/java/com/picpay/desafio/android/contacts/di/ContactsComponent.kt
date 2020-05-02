package com.picpay.desafio.android.contacts.di

import com.picpay.desafio.android.di.ApplicationComponent
import com.picpay.desafio.android.di.FeatureScope
import com.picpay.desafio.android.contacts.ui.activities.ContactsActivity
import com.picpay.desafio.android.di.FeatureComponent
import dagger.Component

//@FeatureScope
//@Component/*(
    //modules = [ContactsModule::class]
//)*/
interface ContactsComponent : FeatureComponent {
    fun inject(activity: ContactsActivity)
}