package com.example.Paging.data.model


import com.google.gson.annotations.SerializedName

data class AllReviews(
    @SerializedName("reviews")
    var reviews: List<ReviewWrapper>? = null
)