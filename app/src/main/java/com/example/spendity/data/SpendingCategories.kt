package com.example.spendity.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpendingCategories {

    @SerializedName("jsonapi")
    @Expose
    var jsonapi: Jsonapi? = null
    @SerializedName("links")
    @Expose
    var links: Links? = null
    @SerializedName("data")
    @Expose
    var data: List<Spending>? = null

}
