package com.example.acenutition.restaurant_details.model

import com.example.acenutition.data.model.AllReviews
import com.example.acenutition.data.model.Photo
import com.example.acenutition.data.model.Review
import com.example.acenutition.data.model.ReviewWrapper

data class Restaurant(
    val restaurantDetails: RestaurantDetails,
    val overview: Overview,
    val photos: List<Photo>,
    val allReviews: AllReviews ? = null
)