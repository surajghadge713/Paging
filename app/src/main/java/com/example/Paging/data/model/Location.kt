package com.example.Paging.data.model


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("address")
    var address: String,
    @SerializedName("locality")
    var locality: String,
    @SerializedName("city")
    var city: String,
    @SerializedName("city_id")
    var cityId: Int,
    @SerializedName("latitude")
    var latitude: String,
    @SerializedName("longitude")
    var longitude: String,
    @SerializedName("zipcode")
    var zipcode: String,
    @SerializedName("country_id")
    var countryId: Int,
    @SerializedName("locality_verbose")
    var localityVerbose: String
)