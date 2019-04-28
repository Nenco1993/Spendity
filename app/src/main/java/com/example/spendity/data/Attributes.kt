package com.example.spendity.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Attributes {

    @SerializedName("amount")
    @Expose
    var amount: String? = null
    @SerializedName("remark")
    @Expose
    var remark: Any? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    var categoryName: String? = null
}
