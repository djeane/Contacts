package com.picpay.desafio.android.contacts.ui.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.picpay.desafio.android.arch.BaseViewModel
import com.picpay.desafio.android.arch.ViewState
import com.picpay.desafio.android.contacts.model.ContactsRepository
import com.picpay.desafio.android.features.contacts.api.service.ContactsService
import javax.inject.Inject

class ContactsViewModel @Inject constructor(
    private val repository: ContactsRepository
) : BaseViewModel() {

    private val successState = mediator<CallState.SuccessState>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getContacts(){
        load {
            repository.getContacts()
            successState.postValue(CallState.SuccessState)
        }
    }

    sealed class CallState : ViewState{
        object SuccessState: CallState()
        object ErrorStare: CallState()
    }
}