package com.example.spendity.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpendingRoot {

    @SerializedName("jsonapi")
    @Expose
    var jsonapi: Jsonapi? = null
    @SerializedName("linksMain")
    @Expose
    var linksMain: LinksMain? = null
    @SerializedName("data")
    @Expose
    var data: List<Spending>? = null

}
