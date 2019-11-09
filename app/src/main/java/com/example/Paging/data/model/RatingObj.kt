package com.example.Paging.data.model


import com.google.gson.annotations.SerializedName

data class RatingObj(
    @SerializedName("title")
    var title: Title,
    @SerializedName("bg_color")
    var bgColor: BgColor
)