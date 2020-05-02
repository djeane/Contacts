package com.picpay.desafio.android.contacts.ui.viewmodel

import com.picpay.desafio.android.arch.BaseViewModel
import com.picpay.desafio.android.features.contacts.api.service.ContactsService
import javax.inject.Inject

class ContactsViewModel @Inject constructor(
    private val service: ContactsService
) : BaseViewModel() {

}