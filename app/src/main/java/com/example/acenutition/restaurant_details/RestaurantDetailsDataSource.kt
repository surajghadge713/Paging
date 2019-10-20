package com.example.acenutition.restaurant_details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.acenutition.data.model.RestaurantX
import com.example.acenutition.data.model.Review
import com.example.acenutition.restaurant_details.model.Overview
import com.example.acenutition.restaurant_details.model.RestaurantDetails
import com.example.mvvmpagingtutorial.data.api.AceNutritionService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class RestaurantDetailsDataSource(
    private val aceNutritionService: AceNutritionService,
    private val compositeDisposable: CompositeDisposable) {

    val TAG ="RestaurantDataSource"

    private val _restaurant = MutableLiveData<com.example.acenutition.restaurant_details.model.Restaurant>()
    val restaurant: LiveData<com.example.acenutition.restaurant_details.model.Restaurant>
        get() = _restaurant


    fun fetchRestaurantDetails(res_id: Int) {

        try {
            compositeDisposable.add(
                aceNutritionService.getRestaurant(res_id)
                    .map(io.reactivex.functions.Function<RestaurantX,com.example.acenutition.restaurant_details.model.Restaurant>(){

                        val restaurantDetails = RestaurantDetails(
                            it.featuredImage,
                            it.name,
                            it.userRating.aggregateRating,
                            it.allReviewsCount,
                            it.cuisines,
                            true
                        )

                        val overiew = Overview(
                            it.phoneNumbers,
                            it.timings,
                            it.url,
                            it.location.address
                        )
                         //restaurant : com.example.acenutition.restaurant_details.model.Restaurant

//                        var reviewList = arrayListOf<Review>()
//
//                        it.allReviews?.let {
//                            it.reviews?.forEach { reviewList.add(it) } }

                        return@Function com.example.acenutition.restaurant_details.model.Restaurant(restaurantDetails,overiew,it.photos,it.allReviews)


                    })
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        _restaurant.postValue(it)
                        Log.d(TAG,"RestaurantX $it")
                    },
                    {
                        Log.d(TAG,"RestaurantX $it")
                    }
                )
            )
        }
        catch (error : Exception){
            Log.d(TAG,"RestaurantX ${error.message}")
        }

    }
}

