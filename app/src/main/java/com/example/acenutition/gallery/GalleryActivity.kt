package com.example.acenutition.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.acenutition.R
import com.example.acenutition.data.model.Photo
import com.example.acenutition.extension.helper.StartSnapHelper
import com.example.acenutition.restaurant_details.adapter.RestaurantPhotoAdapter
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.android.synthetic.main.rc_restaurant_photos.view.*
import android.R.id
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toolbar



class GalleryActivity : AppCompatActivity() {

    val TAG = "GalleryActivity"
    lateinit var photoList : ArrayList<Photo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        //val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        val bundle :Bundle? = intent.extras
        if (bundle!=null){
            photoList = bundle.getParcelableArrayList<Photo>("photoList")

           Log.d(TAG,"photoList : $photoList")

        }

        //val photoList = intent.getSerializableExtra("photoList") as List<*>

        val gridLayoutManager = GridLayoutManager(this,4)
        recyclerPhotoGallery.layoutManager = gridLayoutManager
        val adapter = RestaurantPhotoAdapter(photoList)
        recyclerPhotoGallery.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
