package com.example.acenutition.restaurant_details.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.*
import com.example.acenutition.R
import com.example.acenutition.data.model.Photo
import com.example.acenutition.data.model.Review
import com.example.acenutition.restaurant_details.model.Overview
import com.example.acenutition.restaurant_details.model.Restaurant
import kotlinx.android.synthetic.main.rc_restaurant_overview.view.*
import kotlinx.android.synthetic.main.rc_restaurant_photos.view.*
import kotlinx.android.synthetic.main.rc_restaurant_reviews.view.*
import com.example.acenutition.extension.helper.StartSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.acenutition.gallery.GalleryActivity
import java.io.Serializable


class RestaurantDetailsAdapter(private val it: Restaurant) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TAG = "RestaurantDetailsAdapter"
    var position: Int = 0
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        context = parent.context
        var view : View
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_restaurant_overview,parent,false)
//        return OverviewViewHolder(view)
        when(viewType){
            R.layout.rc_restaurant_overview -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.rc_restaurant_overview,parent,false)
                return OverviewViewHolder(view)
            }
            R.layout.rc_restaurant_photos ->{
                view = LayoutInflater.from(parent.context).inflate(R.layout.rc_restaurant_photos,parent,false)


                return PhotoViewHolder(view)
            }
            R.layout.rc_restaurant_reviews ->{
                view = LayoutInflater.from(parent.context).inflate(R.layout.rc_restaurant_reviews,parent,false)
                return ReviewViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.rc_restaurant_reviews,parent,false)
                return ReviewViewHolder(view)
            }

        }

    }



    override fun getItemCount(): Int {
        return 3
    }

    override fun getItemViewType(position: Int): Int {
        if(position == 0){
            this.position = position
            return R.layout.rc_restaurant_overview
        }
        else if(position == 1){
            this.position = position
            return R.layout.rc_restaurant_photos
        }
        else if(position == 2){
            this.position = position
            return R.layout.rc_restaurant_reviews
        }
        else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(position == 0){
            (holder as OverviewViewHolder).bind(it.overview)
        }
        else if(position == 1){
            (holder as PhotoViewHolder).bind(it.photos)
        }
        else if(position == 2){
            var listReview =  ArrayList<Review>()
            it.allReviews?.let {
                it.reviews?.forEach { it.review?.let { it1 -> listReview.add(it1) } } }

            (holder as ReviewViewHolder).bind(listReview)
        }

    }


    class OverviewViewHolder(val view : View) : RecyclerView.ViewHolder(view){

        fun bind(overview: Overview){
            view.txtPhoneNumber.text = overview.phoneNumber
            view.textView5.text = overview.openingHours
            view.textView12.text = overview.website
            view.textView14.text = overview.address
        }
    }

    class PhotoViewHolder(val view : View) : RecyclerView.ViewHolder(view){

        val context = view.context

        fun bind(photo: List<Photo>){
            val layoutManager = LinearLayoutManager(view.context,RecyclerView.HORIZONTAL,false)
            view.recyclerViewPhoto.layoutManager = layoutManager
            val adapter = RestaurantPhotoAdapter(photo)
            view.recyclerViewPhoto.adapter = adapter


            val startSnapHelper = StartSnapHelper()
            startSnapHelper.attachToRecyclerView(view.recyclerViewPhoto)
//            val snapHelper = LinearSnapHelper()
//            snapHelper.attachToRecyclerView(view.recyclerViewPhoto)
            adapter.notifyDataSetChanged()

            view.txtSeeAll.setOnClickListener {

                val photos = ArrayList<Photo>()
                for (i in 0 until photo.size+5){
                    photos.addAll(photo)
                }
                val bundle = Bundle()
                bundle.putParcelableArrayList("photoList", ArrayList(photos))
                val intent = Intent(view.context,GalleryActivity::class.java)
                intent.putExtras(bundle)
                view.context.startActivity(intent)
            }



        }
    }

    class ReviewViewHolder(val view : View) : RecyclerView.ViewHolder(view){

        fun bind(reviewList: List<Review>){
            view.txtTotalReviewCount.text = "(${reviewList.size} Reviews)"

            val layoutManager = LinearLayoutManager(view.context,RecyclerView.VERTICAL,false)
            view.recyclerViewRestaurantReview.layoutManager = layoutManager
            val adapter = RestaurantReviewAdapter(reviewList)
            view.recyclerViewRestaurantReview.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }


}

private fun Bundle.putSerializable(s: String, photo: List<Photo>) {

}
