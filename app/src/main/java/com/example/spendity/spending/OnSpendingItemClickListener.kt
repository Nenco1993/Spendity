package com.example.spendity.spending

import com.example.spendity.data.Spending

interface OnSpendingItemClickListener {

    fun onSpendingItemClicked(spendingItem: Spending)
}