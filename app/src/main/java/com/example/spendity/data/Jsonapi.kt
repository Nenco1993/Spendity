package com.example.spendity.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Jsonapi {

    @SerializedName("version")
    @Expose
    var version: String? = null

}
