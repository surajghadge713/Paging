package com.example.acenutition.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.acenutition.data.model.Restaurant
import com.example.mvvmpagingtutorial.data.api.AceNutritionService
import io.reactivex.disposables.CompositeDisposable

class RestaurantDataSourceFactory(
    private val aceNutritionService: AceNutritionService,
    private val compositeDisposable: CompositeDisposable) : DataSource.Factory<Int,Restaurant>(){

    val restaurantsDataSourceList = MutableLiveData<RestaurantsDataSource>()

    override fun create(): DataSource<Int, Restaurant> {
        val restaurantsDataSource = RestaurantsDataSource(aceNutritionService,compositeDisposable)
        restaurantsDataSourceList.postValue(restaurantsDataSource)
        return restaurantsDataSource
    }
}