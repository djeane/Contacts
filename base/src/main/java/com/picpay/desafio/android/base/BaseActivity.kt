package com.picpay.desafio.android.base

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.picpay.desafio.android.PicPayApp
import com.picpay.desafio.android.arch.LoadingInterface
import com.picpay.desafio.android.arch.ViewModelInterface

abstract class BaseActivity(@LayoutRes layout: Int) : AppCompatActivity(layout), LoadingInterface {

    open lateinit var loading: ProgressBar

    private val viewModelInterface by lazy { this as? ViewModelInterface<*> }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as PicPayApp).applicationComponent.inject(this)
        inject()
        super.onCreate(savedInstanceState)
        viewModelInterface?.prepareViewModel(this)
    }

    fun setUpToolbarTitle(toolbar: Toolbar, toolbarTile: Int) {
        setSupportActionBar(toolbar).apply {
            title = getString(toolbarTile)
        }
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    open fun inject() {}

    fun getPicPayApp() = applicationContext as PicPayApp
}
