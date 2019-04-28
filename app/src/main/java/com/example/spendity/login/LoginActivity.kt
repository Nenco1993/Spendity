package com.example.spendity.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.spendity.R
import com.example.spendity.ViewModelFactory
import com.example.spendity.data.AuthenticationData
import com.example.spendity.spending.SpendingListActivity
import dagger.android.AndroidInjection
import org.jetbrains.anko.toast
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewmodel: LoginViewModel

    @Inject
    lateinit var viewmodelFactory: ViewModelFactory

    @Inject
    lateinit var authenticationData: AuthenticationData

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this, viewmodelFactory).get(LoginViewModel::class.java)
        //  viewmodel.authenticate(authenticationData)
        Handler().postDelayed({
            toast("login not finished yet")
            startActivity(Intent(baseContext, SpendingListActivity::class.java))
            finish()
        }, 2000)
    }
}
