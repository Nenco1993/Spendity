package com.example.spendity.data

import com.example.spendity.spending.SpendingStatus

data class SpendingResponse(
    val status: SpendingStatus,
    val spendingDataZipped: SpendingDataZipped?
)
