package com.example.Paging.extension

import android.content.Context
import com.example.Paging.R
import android.location.LocationManager.GPS_PROVIDER
import android.content.Context.LOCATION_SERVICE
import android.location.LocationManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService




class view{

    companion object{
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



}

