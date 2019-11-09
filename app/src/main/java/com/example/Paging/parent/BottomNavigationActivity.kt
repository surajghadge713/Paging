package com.example.Paging.parent

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.Paging.R
import kotlinx.android.synthetic.main.activity_bottom_navigation.*


class BottomNavigationActivity : AppCompatActivity() {

    val DURATION : Long = 200
    var flagCollapsed = true
    var dynamicHeight = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        //val navView: BottomNavigationView = findViewById(R.id.nav_view)

        foodOptionEditText.setOnClickListener {
            if(flagCollapsed){
                flagCollapsed = false
                dynamicHeight = 200
            }
            else{
                flagCollapsed = true
                dynamicHeight = 0
            }

            val anim = ValueAnimator.ofInt(linearLayout3.measuredHeight, dynamicHeight)
            anim.addUpdateListener { valueAnimator ->
                val vals = valueAnimator.animatedValue as Int
                val layoutParams = linearLayout3.layoutParams
                layoutParams.height = vals
                linearLayout3.layoutParams = layoutParams
            }
            anim.duration = DURATION
            anim.start()
        }


    }
}
