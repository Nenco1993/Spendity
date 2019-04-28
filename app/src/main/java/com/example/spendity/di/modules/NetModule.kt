package com.example.spendity.di.modules

import com.example.spendity.network.RestApi
import com.example.spendity.shared.SharedConstants.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit
    }

     @Provides
     @Singleton
     fun provideRestAPI(retrofit: Retrofit): RestApi {
         return retrofit.create(RestApi::class.java)
     }
}