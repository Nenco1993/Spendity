package com.example.spendity

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.spendity.data.source.SpendingRepository
import com.example.spendity.login.LoginViewModel
import com.example.spendity.spending.SpendingListViewModel
import com.example.spendity.utils.SchedulersProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    val repository: SpendingRepository,
    val compositeDisposable: CompositeDisposable,
    val schedulers: SchedulersProvider
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository, compositeDisposable, schedulers) as T
        }
        if (modelClass.isAssignableFrom(SpendingListViewModel::class.java)) {
            return SpendingListViewModel(repository, compositeDisposable, schedulers) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}