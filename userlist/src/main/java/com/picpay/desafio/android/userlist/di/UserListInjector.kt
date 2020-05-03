package com.picpay.desafio.android.userlist.di

import com.picpay.desafio.android.userlist.ui.activities.UserListActivity

object UserListInjector {
    @JvmStatic
    fun get(activity: UserListActivity): UserListComponent {
        return activity.getPicPayApp()
            .getOrPutComponent {
                DaggerUserListComponent.builder()
                    .applicationComponent(activity.getPicPayApp().applicationComponent)
                    .build()
            }
    }
}