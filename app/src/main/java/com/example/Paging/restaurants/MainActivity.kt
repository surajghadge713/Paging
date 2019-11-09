package com.example.Paging.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Paging.R
import com.example.mvvmpagingtutorial.data.api.AceNutritionClient
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet_layout.*
import android.widget.Toast
import com.example.Paging.extension.isGPSEnabled
import com.example.Paging.extension.showToastMessage
import com.example.Paging.restaurants.adapter.BottomSheetFilterAdapter
import com.example.Paging.restaurants.callback.OnFilterTypeClickListener


class MainActivity : AppCompatActivity(), OnFilterTypeClickListener {


    val TAG = "MainActivity"
    lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    private lateinit var restaurantViewModel: RestaurantViewModel
    private lateinit var restaurantsPagedListRepository: RestaurantsPagedListRepository
    private lateinit var bottemSheetDialog: BottomSheetDialog
    val filterType = ArrayList<Int>()


    private enum class State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomDialog()
        txtFilter.setOnClickListener {
            val linearLayout = LinearLayoutManager(this)
            val filterAdapter =  BottomSheetFilterAdapter(filterType,this)
            bottemSheetDialog.recyclerViewFilterType.layoutManager = linearLayout
            bottemSheetDialog.recyclerViewFilterType.adapter = filterAdapter
            filterAdapter.notifyDataSetChanged()
            bottemSheetDialog.show()
        }

        showToastMessage(isGPSEnabled().toString())

        val apiService = AceNutritionClient.getClient()

        restaurantsPagedListRepository = RestaurantsPagedListRepository(apiService)

        restaurantViewModel = getViewModel()

        val restaurantAdapter = RestaurantPagedListAdapter(this)
        val linearLayoutManager = LinearLayoutManager(this)


        recyclerRestaurant.layoutManager = linearLayoutManager
        recyclerRestaurant.setHasFixedSize(true)
        recyclerRestaurant.adapter = restaurantAdapter

        restaurantViewModel.restaurantPagedList.observe(this, Observer {
            Log.d(TAG,"restaurantList $it")
            restaurantAdapter.submitList(it)
        })
    }

    private fun getViewModel() : RestaurantViewModel {

        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return RestaurantViewModel(restaurantsPagedListRepository) as T
            }
        })[RestaurantViewModel::class.java]

    }


    private fun setupBottomDialog(){
        filterType.add(R.string.rating)
        filterType.add(R.string.distance)
        filterType.add(R.string.cuisine)

        bottemSheetDialog = BottomSheetDialog(this)
        bottemSheetDialog.setContentView(R.layout.bottom_sheet_layout)
        bottemSheetDialog.dismissWithAnimation = true
        bottemSheetDialog.setOnCancelListener {
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()
            showRating()
        }


        bottemSheetDialog.txtApply.setOnClickListener {
            bottemSheetDialog.cancel()
        }

        bottemSheetDialog.txtClearAll.setOnClickListener {
            bottemSheetDialog.cancel()
        }

    }

    override fun filterTypeClick(filterType: Int) {
        Toast.makeText(this,this.filterType[filterType],Toast.LENGTH_SHORT).show()
        if(filterType == 0){
            showRating()
        }
        else if(filterType == 1){
            showDistance()
        }
        else if(filterType == 2){
            showCusines()
        }
    }

    private fun showRating(){
        if(bottemSheetDialog.constraintRating.id != View.VISIBLE){
            bottemSheetDialog.constraintDistance.visibility = View.GONE
            bottemSheetDialog.recyclerViewFilterCuisine.visibility = View.GONE
            bottemSheetDialog.constraintRating.visibility = View.VISIBLE
        }
    }

    private fun showDistance(){
        if(bottemSheetDialog.constraintDistance.id != View.VISIBLE){
            bottemSheetDialog.constraintRating.visibility = View.GONE
            bottemSheetDialog.recyclerViewFilterCuisine.visibility = View.GONE
            bottemSheetDialog.constraintDistance.visibility = View.VISIBLE
        }
    }

    private fun showCusines(){
        if(bottemSheetDialog.constraintDistance.id != View.VISIBLE){
            bottemSheetDialog.constraintRating.visibility = View.GONE
            bottemSheetDialog.constraintDistance.visibility = View.GONE
            bottemSheetDialog.recyclerViewFilterCuisine.visibility = View.VISIBLE
        }
    }
}
