package com.example.Paging.restaurant_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class RestaurantDetailsViewModel(private val restaurantDetailsRepository: RestaurantDetailsRepository,resId : Int) : ViewModel(){

    private val compositeDisposable = CompositeDisposable()

    val restaurantDetails : LiveData<com.example.Paging.restaurant_details.model.Restaurant> by lazy {
        restaurantDetailsRepository.fetchSingleRestaurantDetails(compositeDisposable,resId)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}