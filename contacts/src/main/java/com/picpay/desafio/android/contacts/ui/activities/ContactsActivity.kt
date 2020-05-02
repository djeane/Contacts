package com.picpay.desafio.android.contacts.ui.activities

import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.arch.ViewModelInterface
import com.picpay.desafio.android.base.BaseActivity
import com.picpay.desafio.android.contacts.R
import com.picpay.desafio.android.contacts.di.ContactsInjector
import com.picpay.desafio.android.contacts.di.ContactsModule
import com.picpay.desafio.android.contacts.ui.adapters.UserListAdapter
import com.picpay.desafio.android.contacts.ui.viewmodel.ContactsViewModel
import javax.inject.Inject

class ContactsActivity : BaseActivity(R.layout.activity_contacts),
    ViewModelInterface<ContactsViewModel> {

    @Inject
    override lateinit var viewModel: ContactsViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: UserListAdapter

    private val url = "http://careers.picpay.com/tests/mobdev/"

    override fun inject() {
        ContactsInjector.get(this).inject(this)
    }

    /*override fun inject() {
        CardsInjector.get(this).plus(CardStatusModule(this)).inject(this)
    }*/

    //private val gson: Gson by lazy { GsonBuilder().create() }

    /*private val okHttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private val service: PicPayService by lazy {
        retrofit.create(PicPayService::class.java)
    }

    override fun onResume() {
        super.onResume()

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.user_list_progress_bar)

        adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        progressBar.visibility = View.VISIBLE
        service.getUsers()
            .enqueue(object : Callback<List<User>> {
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    val message = getString(R.string.error)

                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.GONE

                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    progressBar.visibility = View.GONE

                    adapter.users = response.body()!!
                }
            })
    }*/
}
