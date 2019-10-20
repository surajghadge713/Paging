package com.example.acenutition.parent

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.acenutition.R
import android.view.ViewGroup
import android.animation.ValueAnimator
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_bottom_navigation.*



class BottomNavigationActivity : AppCompatActivity() {

    val DURATION : Long = 200
    var flagCollapsed = true
    var dynamicHeight = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        //val navView: BottomNavigationView = findViewById(R.id.nav_view)

//        textView21.setOnClickListener {
//            if(flagCollapsed){
//                flagCollapsed = false
//                dynamicHeight = 200
//            }
//            else{
//                flagCollapsed = true
//                dynamicHeight = 0
//            }
//
//            val anim = ValueAnimator.ofInt(linearLayout3.measuredHeight, dynamicHeight)
//            anim.addUpdateListener { valueAnimator ->
//                val vals = valueAnimator.animatedValue as Int
//                val layoutParams = linearLayout3.layoutParams
//                layoutParams.height = vals
//                linearLayout3.layoutParams = layoutParams
//            }
//            anim.duration = DURATION
//            anim.start()
//        }


    }
}
