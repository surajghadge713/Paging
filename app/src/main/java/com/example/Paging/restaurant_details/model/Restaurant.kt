package com.example.Paging.restaurant_details.model

import com.example.Paging.data.model.AllReviews
import com.example.Paging.data.model.Photo

data class Restaurant(
    val restaurantDetails: RestaurantDetails,
    val overview: Overview,
    val photos: List<Photo>,
    val allReviews: AllReviews ? = null
)