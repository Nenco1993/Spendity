package com.example.spendity.data.source

import com.example.spendity.data.*
import io.reactivex.Single

interface SpendingDataSource {

    fun authenticate(authenticationData: AuthenticationData): Single<AuthenticationResponse>

    fun loginUser(user: User)

    fun logoutUser(user: User)

    fun getUserInfo(user: User)

    fun getSpendingListData(user: User? = User()): Single<SpendingRoot>

    fun getSpendingItem(itemId: String, user: User = User()): Single<Spending>

    fun getSpendingCategoryList(user: User? = User()): Single<SpendingCategories>
}