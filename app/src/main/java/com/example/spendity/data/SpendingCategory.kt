package com.example.spendity.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpendingCategory {

    @SerializedName("data")
    @Expose
    var data: Data? = null

}
