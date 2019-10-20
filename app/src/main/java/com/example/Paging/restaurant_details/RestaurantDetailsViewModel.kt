package com.example.acenutition.restaurant_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acenutition.data.model.Restaurant
import com.example.acenutition.data.model.RestaurantX
import com.example.mvvmpagingtutorial.data.api.AceNutritionService
import io.reactivex.disposables.CompositeDisposable

class RestaurantDetailsViewModel(private val restaurantDetailsRepository: RestaurantDetailsRepository,resId : Int) : ViewModel(){

    private val compositeDisposable = CompositeDisposable()

    val restaurantDetails : LiveData<com.example.acenutition.restaurant_details.model.Restaurant> by lazy {
        restaurantDetailsRepository.fetchSingleRestaurantDetails(compositeDisposable,resId)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}