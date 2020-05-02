package com.picpay.desafio.android.contacts.di

import com.picpay.desafio.android.contacts.ui.activities.ContactsActivity

object ContactsInjector {
    @JvmStatic
    fun get(activity: ContactsActivity): ContactsComponent {
        return activity.getPicPayApp()
            .getOrPutComponent {
                DaggerContactsComponent.builder()
                    .applicationComponent(activity.getPicPayApp().applicationComponent)
                    .build()
            }
    }
}