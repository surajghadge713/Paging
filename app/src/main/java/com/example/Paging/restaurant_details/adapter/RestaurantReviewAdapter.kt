package com.example.Paging.restaurant_details.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.Paging.R
import com.example.Paging.data.model.Review
import kotlinx.android.synthetic.main.rc_review.view.*
import java.text.SimpleDateFormat
import java.util.*
import android.R.color
import androidx.core.content.ContextCompat
import android.R.color.transparent
import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.widget.RatingBar
import android.graphics.PorterDuff
import androidx.core.graphics.drawable.DrawableCompat
import android.os.Build
import androidx.annotation.ColorInt
import android.graphics.drawable.Drawable
import android.widget.TextView
import com.bumptech.glide.request.RequestOptions
import kotlin.math.roundToInt


class RestaurantReviewAdapter(private val reviewList: List<Review>) : RecyclerView.Adapter<RestaurantReviewAdapter.ReviewViewHolder>(){

    private val TAG = "RestaurantReviewAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_review,parent,false)

        return ReviewViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d(TAG,"getItemCount ${reviewList.size}")
        if(reviewList.size > 5){
            return 4
        }
        else{
            return reviewList.size
        }

    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        //Log.d("RestaurantRev",reviewList[position].toString())

        holder.bind(reviewList[position])

    }

    class ReviewViewHolder(private val view : View) : RecyclerView.ViewHolder(view){

        fun bind(review: Review) {
            Log.d("RestaurantRev review",review.reviewText)
            view.txtReview.text = review.reviewText
            view.txtUsername.text = review.user?.name
            view.txtReviewTimestamp.text = getDateTime(review.timestamp)

            view.txtNumOfLikes.text = "${review.likes} Likes"
            view.txtNumOfHelpfull.text = "${review.commentsCount} Helpful"

            Glide.with(view.context)
                .load(review.user?.profileImage)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.menu_placeholder)
                .into(view.imgUserProfile)

            view.ratingBar.onRatingBarChangeListener =
                RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                    setCurrentRating(view.context,view.ratingBar,review.rating)
                }

            view.ratingBar.progress = review.rating.roundToInt()
            view.txtRatingCount.text = review.rating.roundToInt().toString()
            //view.txtRatingCount.setTextColor(getRatingBarColor(review.rating.roundToInt()))

            setRatingColor(view.txtRatingCount,review.rating.roundToInt())

            Log.d("Restaur_float_to_Int ",review.rating.roundToInt().toString())
        }

        private fun setRatingColor(txtRatingCount: TextView?, rating: Int) {
            when {
                rating <= 1 -> {
                    txtRatingCount!!.setTextColor(ContextCompat.getColor(txtRatingCount.context,R.color.one_start))
                }
                rating in 2..2 -> {
                    txtRatingCount!!.setTextColor(ContextCompat.getColor(txtRatingCount.context,R.color.two_start))
                }
                rating in 3..3 -> {
                    txtRatingCount!!.setTextColor(ContextCompat.getColor(txtRatingCount.context,R.color.three_start))
                }
                rating in 4..4 -> {
                    txtRatingCount!!.setTextColor(ContextCompat.getColor(txtRatingCount.context,R.color.four_start))
                }
                rating in 5..5 -> {
                    txtRatingCount!!.setTextColor(ContextCompat.getColor(txtRatingCount.context,R.color.five_start))
                }
            }

        }

        private fun getDateTime(timestamp: Int): String? {
            try {
                val sdf = SimpleDateFormat("dd/MM/yyyy")
                val netDate = Date(timestamp.toLong())
                return sdf.format(netDate)
            } catch (e: Exception) {
                return e.toString()
            }
        }

        private fun setCurrentRating(mContext : Context,rateOverall : RatingBar,rating: Float) {
            val drawable = rateOverall.progressDrawable as LayerDrawable
            if (mContext != null) {
                when (rating.roundToInt()) {
                    1 -> setRatingStarColor(
                        drawable.getDrawable(2),
                        ContextCompat.getColor(mContext, R.color.one_start)
                    )
                    2 -> setRatingStarColor(
                        drawable.getDrawable(2),
                        ContextCompat.getColor(mContext, R.color.two_start)
                    )
                    3 -> setRatingStarColor(
                        drawable.getDrawable(2),
                        ContextCompat.getColor(mContext, R.color.three_start)
                    )
                    4 -> setRatingStarColor(
                        drawable.getDrawable(2),
                        ContextCompat.getColor(mContext, R.color.four_start)
                    )
                    5 -> setRatingStarColor(
                        drawable.getDrawable(2),
                        ContextCompat.getColor(mContext, R.color.five_start)
                    )
                }
                setRatingStarColor(
                    drawable.getDrawable(1),
                    ContextCompat.getColor(mContext, transparent)
                )
                setRatingStarColor(
                    drawable.getDrawable(0),
                    ContextCompat.getColor(mContext, color.darker_gray)
                )

            }

        }


        private fun setRatingStarColor(drawable: Drawable, @ColorInt color: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                DrawableCompat.setTint(drawable, color)
            } else {
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN)
            }
        }

        private fun getRatingBarColor(rating : Int) : Int {

            return when {
                rating <= 1 -> R.color.one_start
                rating in 2..2 -> R.color.two_start
                rating in 3..3 -> R.color.three_start
                rating in 4..4 -> R.color.four_start
                rating in 5..5 -> R.color.five_start
                else -> 0
            }

        }

    }



}