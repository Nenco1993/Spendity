package com.example.spendity.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Relationships {

    @SerializedName("spendingCategory")
    @Expose
    var spendingCategory: SpendingCategory? = null

}
