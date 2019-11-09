package com.example.Paging.custombarchart

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.Paging.R
import com.example.Paging.extension.animateView
import kotlinx.android.synthetic.main.activity_rating_bar_test.*


class RatingBarTestActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar_test)

        imageView.animateView()

//        val vi =
//            applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//
//        for (i in 0 until 3){
//            val v = vi.inflate(R.layout.rating_item, null)
//            v.id = i
//            linearLayout.addView(
//                v,
//                i,
//                ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT
//                )
//            )
//        }


//        //added LInearLayout
//        val linearLayout = findViewById(R.id.linearLayout) as LinearLayout
//
//        //added LayoutParams
//        val params = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.WRAP_CONTENT,
//            LinearLayout.LayoutParams.WRAP_CONTENT
//        )
//        linearLayout.orientation = LinearLayout.VERTICAL
//
//        //add textView
//        val textView = TextView(this)
//        textView.text = "The developer world is yours"
//        textView.id = 1
//        textView.layoutParams = params
//
//        // added Button
//        val button = Button(this)
//        button.setText("thedeveloperworldisyours")
//        button.setId(2)
//
//        //added the textView and the Button to LinearLayout
//        linearLayout.addView(textView)
//        linearLayout.addView(button)


    }
}
