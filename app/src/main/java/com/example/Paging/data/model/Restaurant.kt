package com.example.Paging.data.model


import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("restaurant")
    var restaurant: RestaurantX


) {
    override fun toString(): String {
        return "Restaurant(restaurant=$restaurant)"
    }
}