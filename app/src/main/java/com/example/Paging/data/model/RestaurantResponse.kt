package com.example.Paging.data.model


import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    @SerializedName("results_found")
    var resultsFound: Int,
    @SerializedName("results_start")
    var resultsStart: Int,
    @SerializedName("results_shown")
    var resultsShown: Int,
    @SerializedName("restaurants")
    var restaurants: List<Restaurant>



) {
    override fun toString(): String {
        return "RestaurantResponse(resultsFound=$resultsFound, resultsStart=$resultsStart, resultsShown=$resultsShown, restaurants=$restaurants)"
    }
}