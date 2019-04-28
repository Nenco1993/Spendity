package com.example.spendity.spending

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.spendity.data.*
import com.example.spendity.data.source.SpendingRepository
import com.example.spendity.utils.SchedulersProvider
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import timber.log.Timber
import javax.inject.Inject

class SpendingListViewModel @Inject constructor(
    val repository: SpendingRepository,
    val compositeDisposable: CompositeDisposable,
    val schedulers: SchedulersProvider
) : ViewModel() {

    val mutableSpendings = MutableLiveData<SpendingResponse>()

    val liveSpendings: LiveData<SpendingResponse>
        get() = mutableSpendings

    fun loadSpendingItems() {
        val singleSpendingsZipped = Single.zip(
            repository.getSpendingListData(),
            repository.getSpendingCategoryList(),
            BiFunction { spendingRoot: SpendingRoot, spendingCategories: SpendingCategories ->
                SpendingDataZipped(spendingRoot, spendingCategories)
            })

        val disposableSpendingList = singleSpendingsZipped
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .subscribe(
                {
                    onSpendingItemsLoaded(it)
                },
                {
                    onSpendingItemsNotAvailable(it)
                }
            )
        compositeDisposable.add(disposableSpendingList)
    }

    private fun onSpendingItemsLoaded(items: SpendingDataZipped?) {
        val itemsSorted = assignCategoriesToSpendings(items)
        mutableSpendings.value = SpendingResponse(SpendingStatus.SUCCESS, itemsSorted)
    }

    private fun onSpendingItemsNotAvailable(throwable: Throwable?) {
        mutableSpendings.value = SpendingResponse(SpendingStatus.ERROR, null)
        throwable?.printStackTrace()
    }

    private fun assignCategoriesToSpendings(items: SpendingDataZipped?): SpendingDataZipped? {
        items?.spendingListResponse?.data?.forEach { spending ->
            items.spendingCategoriesResponse.data?.forEach { categoryData ->
                if (spending.relationships?.spendingCategory?.data?.id.equals(categoryData.id)) {
                    spending.attributes?.categoryName = categoryData.attributes?.name
                }
            }
        }
        return items
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}