package com.example.Paging.restaurants

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.Paging.R
import com.example.Paging.data.model.Restaurant
import com.example.Paging.restaurant_details.RestaurantDetailsActivity
import kotlinx.android.synthetic.main.rc_item.view.*

class RestaurantPagedListAdapter(private val context : Context) : PagedListAdapter<Restaurant,RecyclerView.ViewHolder>(RestaurantDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view  = layoutInflater.inflate(R.layout.rc_item,parent,false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(getItem(position),context)
    }


    class RestaurantDiffCallback : DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.restaurant.id == newItem.restaurant.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val TAG = "RestPLAdapter"
        fun bind(restaurant: Restaurant?,context: Context){
            Log.d(TAG,"restaurant "+restaurant?.restaurant?.name)
            itemView.txtRestaurantName.text = restaurant?.restaurant?.name
            itemView.txtRestaurantDistance.text = "2.3 km away"
            itemView.txtRestaurantCuisine.text = restaurant?.restaurant?.cuisines
            itemView.txtRating.text = "${restaurant?.restaurant?.userRating?.aggregateRating}"
            Glide.with(context)
                .load(restaurant?.restaurant?.thumb)
                .placeholder(R.drawable.menu_placeholder)
                .into(itemView.imgRestaurant)
            itemView.setOnClickListener{
                val intent = Intent(context,RestaurantDetailsActivity::class.java)
                intent.putExtra("res_id",restaurant?.restaurant?.id)
                context.startActivity(intent)
            }
        }
    }
}