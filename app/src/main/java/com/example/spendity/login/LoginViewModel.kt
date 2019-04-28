package com.example.spendity.login

import android.arch.lifecycle.ViewModel
import com.example.spendity.data.AuthenticationData
import com.example.spendity.data.AuthenticationResponse
import com.example.spendity.data.source.SpendingRepository
import com.example.spendity.utils.SchedulersProvider
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    val repository: SpendingRepository,
    val compositeDisposable: CompositeDisposable,
    val schedulers: SchedulersProvider
) : ViewModel() {

    fun authenticate(authenticationData: AuthenticationData) {
        val disposableAuthentication = repository.authenticate(authenticationData)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .subscribe(
                {
                    onAuthenticationSuccessful(it)
                },
                {
                    onAuthenticationFailed(it)
                }
            )
        compositeDisposable.add(disposableAuthentication)
    }

    private fun onAuthenticationFailed(throwable: Throwable?) {
        //TODO handle properly when you have time
        throwable?.printStackTrace()
        Timber.d("onAuthenticationFailed")
    }

    private fun onAuthenticationSuccessful(response: AuthenticationResponse?) {
        Timber.d("onAuthenticationSuccessful")
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}