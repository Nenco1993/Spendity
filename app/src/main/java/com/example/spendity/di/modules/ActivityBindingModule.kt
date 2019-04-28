package com.example.spendity.di.modules

import com.example.spendity.di.scopes.ActivityScope
import com.example.spendity.login.LoginActivity
import com.example.spendity.spending.SpendingListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SpendingListModule::class])
    abstract fun bindSpendingListActivity(): SpendingListActivity
}