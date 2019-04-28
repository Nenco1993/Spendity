package com.example.spendity.di.modules

import android.content.Context
import com.example.spendity.SpendityApplication
import com.example.spendity.data.AuthenticationData
import com.example.spendity.data.source.SpendingDataSource
import com.example.spendity.data.source.SpendingRepository
import com.example.spendity.shared.SharedConstants.AUTHENTICATION_VALUE_CLIENT_ID
import com.example.spendity.shared.SharedConstants.AUTHENTICATION_VALUE_CLIENT_SECRET
import com.example.spendity.shared.SharedConstants.AUTHENTICATION_VALUE_GRANT_TYPE
import com.example.spendity.utils.SchedulersProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: SpendityApplication): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideRepository(repository: SpendingRepository): SpendingDataSource {
        return repository
    }

    @Provides
    @Singleton
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @Singleton
    fun provideSchedulers(): SchedulersProvider {
        return SchedulersProvider()
    }

    @Provides
    @Singleton
    fun provideAuthenticationData(): AuthenticationData {
        return AuthenticationData(
            AUTHENTICATION_VALUE_CLIENT_ID,
            AUTHENTICATION_VALUE_CLIENT_SECRET,
            AUTHENTICATION_VALUE_GRANT_TYPE
        )
    }
}