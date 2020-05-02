package com.picpay.desafio.android.base

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.picpay.desafio.android.PicPayApp
import com.picpay.desafio.android.arch.LoadingInterface

open class BaseActivity(@LayoutRes layout: Int) : AppCompatActivity(layout), LoadingInterface {

    private val loading by lazy { ProgressBar(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as PicPayApp).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }
}
