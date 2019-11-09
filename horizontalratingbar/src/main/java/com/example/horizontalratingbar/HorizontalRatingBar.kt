package com.example.horizontalratingbar

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.LinearLayout
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.ratingbar_item.view.*
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Build
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.marginStart


class HorizontalRatingBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    val TAG = "HorizontalRatingBar"

    lateinit var colorList: IntArray
    var ratingValueList : IntArray? = null
    var totalRatingCount : Int = 0
    var barBorderColor : Int = 0
    var barBorderWidth : Int = 0
    var typefacePath : String? = null


    init {
        this.orientation = VERTICAL
        this.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        val vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        //val ratingLayout = vi.inflate(R.layout.ratingbar_layout, null)
        attrs?.let {
            val styledAttributes = context.obtainStyledAttributes(it, R.styleable.HorizontalRatingBar, 0, 0)
            barBorderColor = styledAttributes.getInt(R.styleable.HorizontalRatingBar_barBorderColor,0)
            barBorderWidth = styledAttributes.getDimension(R.styleable.HorizontalRatingBar_barBorderWidth,0.0F).toInt()

            val ratingColorsId = styledAttributes.getResourceId(R.styleable.HorizontalRatingBar_ratingColors,0)
            colorList = styledAttributes.resources.getIntArray(ratingColorsId)
            val ratingValuesId = styledAttributes.getResourceId(R.styleable.HorizontalRatingBar_ratingValues,0)
            typefacePath = styledAttributes.getString(R.styleable.HorizontalRatingBar_typefacePath).toString()
            if(ratingValuesId != 0){
                ratingValueList = styledAttributes.resources.getIntArray(ratingValuesId)
                for (i in ratingValueList!!.indices){
                    totalRatingCount += ratingValueList!!.get(i)
                }
            }

            val numOfBars = styledAttributes.getInteger(R.styleable.HorizontalRatingBar_numOfBars, 5)

            Log.d(TAG,"setRatingBarProgressColor totalRatingCount ${totalRatingCount}")

            for (i in 0 until  numOfBars){
                val v = vi.inflate(R.layout.ratingbar_item, null)
                val starts = numOfBars - i
                setRatingStar(v.ratingLinearLayout,starts)
                setRatingBarProgressColor(v.progressBarConstraint,starts)
                setRatingValue(v.txtRating,ratingValueList!!.get(starts-1))

                this.addView(
                    v,
                    i,
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )

            }

        }
    }

    private fun setRatingValue(txtRating: TextView?, i: Int) {
        txtRating?.text = i.toString()
        if(typefacePath != null){
            Log.d(TAG,"typefacePath : $typefacePath")
            val typeface = Typeface.createFromAsset(context.assets, typefacePath)
            txtRating?.typeface = typeface
        }
    }

    private fun setRatingStar(ratingLinearLayout: LinearLayout, numOfStar: Int) {
        //ratingBar.numStars = numOfStar
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(3, top, 3, bottom);
        lp.gravity = Gravity.CENTER_VERTICAL
        for (i in 0 until numOfStar){
            val imageView = ImageView(context)
            imageView.layoutParams = lp
            if(numOfStar == 1){
                imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_icon_star_red))
            }
            else if(numOfStar == 2){
                imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_icon_star_yellow))
            }

            else if(numOfStar == 3){
                imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_icon_star_green_lime))
            }
            else if(numOfStar == 4){
                imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_icon_star_green_drk))
            }
            else if(numOfStar == 5){
                imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_icon_star_green))
            }

            ratingLinearLayout.addView(imageView)
        }
        ratingLinearLayout.invalidate()

    }


    private fun setRatingBarProgressColor(constraintLayout: ConstraintLayout, numOfStar: Int) {

        customView(constraintLayout,Color.WHITE,barBorderColor)
        constraintLayout.view.setBackgroundColor(colorList[numOfStar-1])
        ratingValueList?.get(numOfStar-1)?.let { it1 ->

            setRatingBarProgress(constraintLayout.guideline,it1.toFloat()/totalRatingCount)
        }
    }

    private fun setRatingBarProgress(guideline: Guideline,progress : Float){
        guideline.setGuidelinePercent(progress)
    }


    private fun customView(v: View, backgroundColor: Int, borderColor: Int) {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadii = floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        shape.setColor(backgroundColor)
        shape.setStroke(barBorderWidth, borderColor)
        v.background = shape
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

}