package com.picpay.desafio.android.contacts.ui.viewmodel

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.picpay.desafio.android.arch.BaseViewModel
import com.picpay.desafio.android.arch.ViewState
import com.picpay.desafio.android.contacts.model.ContactsRepository
import com.picpay.desafio.android.features.contacts.api.response.ContactsResponse
import javax.inject.Inject

class ContactsViewModel @Inject constructor(
    private val repository: ContactsRepository
) : BaseViewModel() {

    private val successState = mediator<CallState.SuccessState>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getContacts() {
        load {
            val list = repository.getContacts()
            Log.d("Result", list.toString())
            successState.postValue(CallState.SuccessState(list))
        }
    }

    sealed class CallState : ViewState {
        class SuccessState(val contacts: List<ContactsResponse>) : CallState()
        object ErrorStare : CallState()
    }
}