package com.example.acenutition.data.model


import com.google.gson.annotations.SerializedName

data class UserRating(
    @SerializedName("aggregate_rating")
    var aggregateRating: Float,
    @SerializedName("rating_text")
    var ratingText: String,
    @SerializedName("rating_color")
    var ratingColor: String,
    @SerializedName("rating_obj")
    var ratingObj: RatingObj,
    @SerializedName("votes")
    var votes: Int,
    @SerializedName("custom_rating_text")
    var customRatingText: String,
    @SerializedName("custom_rating_text_background")
    var customRatingTextBackground: String,
    @SerializedName("rating_tool_tip")
    var ratingToolTip: String
)