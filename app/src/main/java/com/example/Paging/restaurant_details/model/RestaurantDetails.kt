package com.example.acenutition.restaurant_details.model

data class RestaurantDetails(
    val restaurantUrl : String?,
    val name : String?,
    val rating : Float?,
    val reviewCount : Int?,
    val cuisines : String?,
    val been_there : Boolean?
)