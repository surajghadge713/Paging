package com.example.mvvmpagingtutorial.data.api

import com.example.Paging.data.model.RestaurantResponse
import com.example.Paging.data.model.RestaurantX
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AceNutritionService {

    @GET("search")
    fun getRestaurants(
        @Query("start") start : Int,
        @Query("count") count : Int
    ) : Single<RestaurantResponse>


    @GET("restaurant")
    fun getRestaurant(
        @Query("res_id") res_id : Int
    ) : Single<RestaurantX>

}