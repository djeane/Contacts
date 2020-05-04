package com.picpay.desafio.android.userlist.ui.viewmodel

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.picpay.desafio.android.arch.BaseViewModel
import com.picpay.desafio.android.arch.ViewState
import com.picpay.desafio.android.features.contacts.api.response.UserListResponse
import com.picpay.desafio.android.userlist.model.UserListRepository
import javax.inject.Inject

class UserListViewModel @Inject constructor(
    private val repository: UserListRepository
) : BaseViewModel() {

    private val successState = mediator<CallState.SuccessState>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getContacts() {
        load {
            val list = repository.getUserList()
            Log.d("Result", list.toString())
            successState.postValue(CallState.SuccessState(list))
        }
    }

    sealed class CallState : ViewState {
        class SuccessState(val contacts: MutableList<UserListResponse>) : CallState()
        object ErrorStare : CallState()
    }
}