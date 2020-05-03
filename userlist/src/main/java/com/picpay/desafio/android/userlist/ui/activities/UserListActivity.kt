package com.picpay.desafio.android.userlist.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.arch.ViewModelInterface
import com.picpay.desafio.android.arch.ViewState
import com.picpay.desafio.android.base.BaseActivity
import com.picpay.desafio.android.userlist.R
import com.picpay.desafio.android.userlist.di.UserListInjector
import com.picpay.desafio.android.userlist.ui.adapters.UserListAdapter
import com.picpay.desafio.android.userlist.ui.viewmodel.UserListViewModel
import com.picpay.desafio.android.userlist.ui.viewmodel.UserListViewModel.CallState.SuccessState
import com.picpay.desafio.android.features.contacts.api.response.UserListResponse
import kotlinx.android.synthetic.main.activity_user_list.*
import javax.inject.Inject

class UserListActivity : BaseActivity(R.layout.activity_user_list),
    ViewModelInterface<UserListViewModel> {

    @Inject
    override lateinit var viewModel: UserListViewModel

    override fun inject() {
        UserListInjector.get(this).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpToolbarTitle(toolbar, R.string.title_user_list)
        loading = user_list_progress_bar
    }

    override fun renderState(state: ViewState?) {
        when (state) {
            is SuccessState -> renderSuccessState(state.contacts)
            else -> super.renderState(state)
        }
    }

    private fun renderSuccessState(contacts: List<UserListResponse>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserListAdapter().apply { userList = contacts }
    }
}
