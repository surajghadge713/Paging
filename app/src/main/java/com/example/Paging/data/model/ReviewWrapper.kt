package com.example.Paging.data.model

import com.google.gson.annotations.SerializedName

data class ReviewWrapper(

    @field:SerializedName("review")
    var review: Review? = null

)