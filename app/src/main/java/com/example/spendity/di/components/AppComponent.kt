package com.example.spendity.di.components

import com.example.spendity.SpendityApplication
import com.example.spendity.di.modules.ActivityBindingModule
import com.example.spendity.di.modules.AppModule
import com.example.spendity.di.modules.NetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, NetModule::class, ActivityBindingModule::class))
interface AppComponent {

    @Component.Builder
    interface AppComponentBuilder {
        @BindsInstance
        fun setApplication(app: SpendityApplication): AppComponentBuilder
        fun build(): AppComponent
    }

    fun inject(activity: SpendityApplication)
}