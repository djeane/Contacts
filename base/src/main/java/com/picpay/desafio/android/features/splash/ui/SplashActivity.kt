package com.picpay.desafio.android.features.splash.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val activityName = "com.picpay.desafio.android.contacts.ui.activities.ContactsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, Class.forName(activityName)))
        finish()
    }
}