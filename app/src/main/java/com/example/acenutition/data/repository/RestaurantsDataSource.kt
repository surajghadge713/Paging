package com.example.acenutition.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.acenutition.data.model.Restaurant
import com.example.mvvmpagingtutorial.data.api.AceNutritionService
import com.example.mvvmpagingtutorial.data.api.FISRT_PAGE
import com.example.mvvmpagingtutorial.data.api.RESTAURANTS_PER_PAGE
import com.example.mvvmpagingtutorial.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RestaurantsDataSource(private val aceNutritionService: AceNutritionService,
                            private val compositeDisposable: CompositeDisposable) : PageKeyedDataSource<Int, Restaurant>() {

    private val TAG = "RestaurantsDat"

    val networkState : MutableLiveData<NetworkState> = MutableLiveData()
    val page = FISRT_PAGE

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Restaurant>) {

        networkState.postValue(NetworkState.LOADING)
        compositeDisposable.add(
            aceNutritionService.getRestaurants(page, RESTAURANTS_PER_PAGE)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    callback.onResult(it.restaurants,null,page)
                    Log.d(TAG, "MoviesDataSource loadInitial $page")
                    Log.d(TAG,"MoviesDataSource "+it.restaurants)
                    networkState.postValue(NetworkState.LOADED)
                },
                    {
                        Log.d(TAG,"exception "+it.message)
                        networkState.postValue(NetworkState.ERROR)
                })
        )

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Restaurant>) {
        networkState.postValue(NetworkState.LOADING)
        compositeDisposable.add(
            aceNutritionService.getRestaurants(params.key, RESTAURANTS_PER_PAGE)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.d(TAG, "MoviesDataSource loadAfter ${params.key+ 1}")
                    callback.onResult(it.restaurants,params.key+ 1)
                    Log.d(TAG,"MoviesDataSource "+it.restaurants)
                    networkState.postValue(NetworkState.LOADED)
                },
                    {
                        Log.d(TAG,"exception "+it.message)
                        networkState.postValue(NetworkState.ERROR)
                    })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Restaurant>) {

    }
}