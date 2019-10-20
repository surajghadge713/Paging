package com.example.acenutition.restaurant_details

import androidx.lifecycle.LiveData
import com.example.acenutition.data.model.RestaurantX
import com.example.mvvmpagingtutorial.data.api.AceNutritionService
import io.reactivex.disposables.CompositeDisposable

class RestaurantDetailsRepository(private val aceNutritionService: AceNutritionService) {

    lateinit var restaurantDetailsDataSource : RestaurantDetailsDataSource

    fun fetchSingleRestaurantDetails(compositeDisposable: CompositeDisposable,resId : Int) : LiveData<com.example.acenutition.restaurant_details.model.Restaurant> {

        restaurantDetailsDataSource = RestaurantDetailsDataSource(aceNutritionService ,compositeDisposable)
        restaurantDetailsDataSource.fetchRestaurantDetails(resId)

        return restaurantDetailsDataSource.restaurant

    }


}