package com.example.Paging.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.Paging.data.model.Restaurant
import io.reactivex.disposables.CompositeDisposable

class RestaurantViewModel(
    private val restaurantsPagedListRepository: RestaurantsPagedListRepository) : ViewModel(){

    private val compositeDisposable = CompositeDisposable()


    val restaurantPagedList : LiveData<PagedList<Restaurant>> by lazy {
        restaurantsPagedListRepository.fetchRestaurancePagedList(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}