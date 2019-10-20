package com.example.acenutition.restaurant_details.model

data class Overview(
    val phoneNumber : String,
    val openingHours : String,
    val website : String,
    val address : String,
    var olaPrice : String = "100 - 250",
    var uberPrice : String = "100 - 250"

)