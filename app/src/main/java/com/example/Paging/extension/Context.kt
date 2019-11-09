package com.example.Paging.extension

import android.content.Context
import android.location.LocationManager
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast

fun Context.isGPSEnabled(): Boolean {
    val locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
}

fun Context.showToastMessage(messsge : String){
    Toast.makeText(this,messsge, Toast.LENGTH_SHORT).show()
}

fun View.animateView(){
    val anim = ScaleAnimation(
        0.3f,
        1.0f,
        0.3f,
        1.0f,
        Animation.RELATIVE_TO_SELF,
        0.5f,
        Animation.RELATIVE_TO_SELF,
        0.5f
    )


    anim.duration = 900
    this.startAnimation(anim)
}