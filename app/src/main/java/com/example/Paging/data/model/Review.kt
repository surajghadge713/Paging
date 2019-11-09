package com.example.Paging.data.model


import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("rating")
    var rating: Float,
    @SerializedName("review_text")
    var reviewText: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("rating_color")
    var ratingColor: String,
    @SerializedName("review_time_friendly")
    var reviewTimeFriendly: String,
    @SerializedName("rating_text")
    var ratingText: String,
    @SerializedName("timestamp")
    var timestamp: Int,
    @SerializedName("likes")
    var likes: Int,
    @SerializedName("user")
    var user: User ? = null,
    @SerializedName("comments_count")
    var commentsCount: Int
)