package com.example.Paging.data.model


import com.google.gson.annotations.SerializedName

data class BgColor(
    @SerializedName("type")
    var type: String,
    @SerializedName("tint")
    var tint: String
)