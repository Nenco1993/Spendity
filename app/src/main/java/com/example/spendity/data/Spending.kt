package com.example.spendity.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Spending {

    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("attributes")
    @Expose
    var attributes: Attributes? = null
    @SerializedName("relationships")
    @Expose
    var relationships: Relationships? = null
    @SerializedName("links")
    @Expose
    var links: Links? = null
    var isExpanded: Boolean = false

}
