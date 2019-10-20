package com.example.acenutition.restaurant_details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.acenutition.R
import com.example.acenutition.data.model.Photo
import com.example.acenutition.data.model.PhotoX
import kotlinx.android.synthetic.main.activity_restaurant_details.*
import kotlinx.android.synthetic.main.rc_photo.view.*
import kotlinx.android.synthetic.main.rc_restaurant_overview.view.*
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation


class RestaurantPhotoAdapter(private val photoList: List<Photo>) :
    RecyclerView.Adapter<RestaurantPhotoAdapter.PhotoViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_photo, parent, false)

        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoList.get(position).photo)
    }

    class PhotoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val FADE_DURATION : Long = 500 //FADE_DURATION in milliseconds

        fun bind(photo: PhotoX) {
            Glide.with(view.context)
                .load(photo.url)
                .placeholder(R.drawable.menu_placeholder)
                .into(view.imgPhoto)

            // Set the view to fade in
            setFadeAnimation(view.imgPhoto)
        }

        private fun setFadeAnimation(view: View) {
//            val anim = AlphaAnimation(0.0f, 1.0f)
            val anim = ScaleAnimation(
                0.5f,
                1.0f,
                0.5f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )

            anim.duration = FADE_DURATION
            view.startAnimation(anim)
        }

    }


}