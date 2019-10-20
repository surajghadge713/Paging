package com.example.acenutition.restaurant_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.acenutition.R
import com.example.acenutition.restaurant_details.adapter.RestaurantDetailsAdapter
import com.example.mvvmpagingtutorial.data.api.AceNutritionClient
import kotlinx.android.synthetic.main.activity_restaurant_details.*
import com.example.acenutition.restaurant_details.RestaurantDetailsViewModel as RestaurantDetailsViewModel

class RestaurantDetailsActivity : AppCompatActivity() {

    val TAG = "RestaurantDeta"
    private lateinit var viewModel: RestaurantDetailsViewModel
    lateinit var restaurantDetailsRepository: RestaurantDetailsRepository

    val resId : Int by lazy {
        intent.getStringExtra("res_id").toInt()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)

        Toast.makeText(this@RestaurantDetailsActivity,intent.getStringExtra("res_id"),Toast.LENGTH_SHORT).show()

        val aceNutritionService = AceNutritionClient.getClient()

        restaurantDetailsRepository = RestaurantDetailsRepository(aceNutritionService)

        viewModel = getViewModel()

        val linearLayout = LinearLayoutManager(this)
        recyclerViewRestaurant.layoutManager = linearLayout

        viewModel.restaurantDetails.observe(this, Observer {
            Log.d(TAG,"RestaurantDetailsActivity : $it")
            collapsing_toolbar.title = it.restaurantDetails.name
            txtRestaurantName.text = it.restaurantDetails.name
            txtRestaurantRating.text = it.restaurantDetails.rating.toString()
            txtRestaurantRating.background = ContextCompat.getDrawable(this,getRatingDrawable(it.restaurantDetails.rating!!))
            txtCuisines.text = it.restaurantDetails.cuisines
            txtReviewCount.text = it.restaurantDetails.reviewCount.toString() + " Reviews"

            Glide.with(this)
                .load(it.restaurantDetails.restaurantUrl)
                .placeholder(R.drawable.menu_placeholder)
                .into(imgRestaurant)

            val adapter = RestaurantDetailsAdapter(it)
            recyclerViewRestaurant.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    private fun getViewModel() : RestaurantDetailsViewModel {

        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return RestaurantDetailsViewModel(restaurantDetailsRepository,resId) as T
            }
        })[RestaurantDetailsViewModel::class.java]

    }

    fun getRatingDrawable(rating : Float) : Int {

        if(rating <= 1.0){
            return R.drawable.rating_01
        }
        else if(rating > 1.0 &&  rating <= 2.0){
            return R.drawable.rating_02
        }
        else if(rating > 2.0 &&  rating <= 3.0){
            return R.drawable.rating_03
        }
        else if(rating > 3.0 &&  rating <= 4.0){
            return R.drawable.rating_04
        }
        else if(rating > 4.0 &&  rating <= 5.0){
            return R.drawable.rating_05
        }

        return 0
    }


}
