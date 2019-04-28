package com.example.spendity.data

import com.example.spendity.spending.SpendingStatus

data class SpendingCategoriesResponse(
    val status: SpendingStatus,
    val spendingCategories: SpendingCategories?
)
