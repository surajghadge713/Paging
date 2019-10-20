package com.example.acenutition.extension

import android.graphics.drawable.Drawable
import com.example.acenutition.R


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

