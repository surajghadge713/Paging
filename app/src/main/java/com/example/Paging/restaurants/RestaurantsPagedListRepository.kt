package com.example.Paging.restaurants

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.Paging.data.model.Restaurant
import com.example.Paging.data.repository.RestaurantDataSourceFactory
import com.example.mvvmpagingtutorial.data.api.AceNutritionService
import com.example.mvvmpagingtutorial.data.api.RESTAURANTS_PER_PAGE
import io.reactivex.disposables.CompositeDisposable

class RestaurantsPagedListRepository(private val aceNutritionService: AceNutritionService) {

    lateinit var restaurantPagedList: LiveData<PagedList<Restaurant>>
    lateinit var movieDataSourceFactory: RestaurantDataSourceFactory

    fun fetchRestaurancePagedList(
        compositeDisposable: CompositeDisposable) : LiveData<PagedList<Restaurant>>{

        movieDataSourceFactory = RestaurantDataSourceFactory(aceNutritionService,compositeDisposable)


        val config=PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(RESTAURANTS_PER_PAGE)
            .build()

        restaurantPagedList = LivePagedListBuilder(movieDataSourceFactory,config).build()

        return restaurantPagedList

    }
}