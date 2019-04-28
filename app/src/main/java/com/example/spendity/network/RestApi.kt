package com.example.spendity.network

import com.example.spendity.data.*
import com.example.spendity.shared.SharedConstants.ROUTE_AUTHENTICATE
import com.example.spendity.shared.SharedConstants.ROUTE_SPENDINGS_LIST
import com.example.spendity.shared.SharedConstants.ROUTE_SPENDINGS_LIST_CATEGORIES
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.*

interface RestApi {

    @POST(ROUTE_AUTHENTICATE)
    fun authenticate(@Body authenticationData: AuthenticationData): Single<AuthenticationResponse>

    @GET(ROUTE_SPENDINGS_LIST)
    fun getListSpendingsItems(): Single<SpendingRoot>

    @GET(ROUTE_SPENDINGS_LIST_CATEGORIES)
    fun getListSpendingsCategories(): Single<SpendingCategories>

    @GET("$ROUTE_SPENDINGS_LIST/{id}")
    fun getSpendingItem(@Path("id") itemId: String)
}