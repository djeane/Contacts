package com.picpay.desafio.android.contacts.ui.activities

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.arch.ViewModelInterface
import com.picpay.desafio.android.arch.ViewState
import com.picpay.desafio.android.base.BaseActivity
import com.picpay.desafio.android.contacts.R
import com.picpay.desafio.android.contacts.ui.adapters.UserListAdapter
import com.picpay.desafio.android.contacts.ui.viewmodel.ContactsViewModel
import com.picpay.desafio.android.contacts.ui.viewmodel.ContactsViewModel.CallState.SuccessState
import kotlinx.android.synthetic.main.activity_contacts.*
import javax.inject.Inject

class ContactsActivity : BaseActivity(R.layout.activity_contacts),
    ViewModelInterface<ContactsViewModel> {

    @Inject
    override lateinit var viewModel: ContactsViewModel

    companion object {
        fun getStartIntent(context: Context) = Intent(context, ContactsActivity::class.java)
    }
    /*override fun inject() {
        ContactsInjector.get(this).inject(this)
    }*/

    override fun renderState(state: ViewState?) {
        when (state) {
            is SuccessState -> renderSuccessState()
            else -> super.renderState(state)
        }
    }

    private fun renderSuccessState() {
        val adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        Toast.makeText(this, "Contatos apareceram", Toast.LENGTH_SHORT)
            .show()
    }
}
