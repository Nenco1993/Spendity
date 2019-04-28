package com.example.spendity.data.source

import com.example.spendity.data.*
import com.example.spendity.network.RestApi
import io.reactivex.Single
import javax.inject.Inject

class SpendingRepository @Inject constructor(val api: RestApi) : SpendingDataSource {

    override fun authenticate(authenticationData: AuthenticationData): Single<AuthenticationResponse> {
        return api.authenticate(authenticationData)
    }

    override fun loginUser(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logoutUser(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserInfo(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSpendingListData(user: User?): Single<SpendingRoot> {
        val singleSpendingList = api.getListSpendingsItems()
        if (user != null) {
            //TODO get spending list by user
        }
        return singleSpendingList
    }

    override fun getSpendingItem(itemId: String, user: User): Single<Spending> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSpendingCategoryList(user: User?): Single<SpendingCategories> {
        val singleSpendingCategories = api.getListSpendingsCategories()
        if (user != null) {
            //TODO get spending categories by user
        }
        return singleSpendingCategories
    }
}