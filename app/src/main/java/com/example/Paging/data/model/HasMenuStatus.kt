package com.example.Paging.data.model


import com.google.gson.annotations.SerializedName

data class HasMenuStatus(
    @SerializedName("delivery")
    var delivery: Int,
    @SerializedName("takeaway")
    var takeaway: Int
)