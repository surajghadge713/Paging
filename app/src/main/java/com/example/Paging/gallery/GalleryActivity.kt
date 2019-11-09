package com.example.Paging.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.Paging.R
import com.example.Paging.data.model.Photo
import com.example.Paging.restaurant_details.adapter.RestaurantPhotoAdapter
import kotlinx.android.synthetic.main.activity_gallery.*


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
