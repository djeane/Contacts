package com.picpay.desafio.android.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import com.picpay.desafio.android.PicPayApp

open class BaseActivity(@LayoutRes layout: Int) : AppCompatActivity(layout) {

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as PicPayApp).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}
