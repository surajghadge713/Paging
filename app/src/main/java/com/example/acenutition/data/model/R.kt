package com.example.acenutition.data.model


import com.google.gson.annotations.SerializedName

data class R(
    @SerializedName("has_menu_status")
    var hasMenuStatus: HasMenuStatus,
    @SerializedName("res_id")
    var resId: Int
)