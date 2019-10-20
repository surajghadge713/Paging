package com.example.acenutition.restaurants.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.acenutition.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.rc_filter_type_item.view.*
import android.graphics.Color.parseColor
import com.example.acenutition.restaurants.callback.OnFilterTypeClickListener


class BottomSheetFilterAdapter(
    private val filterType : List<Int>,
    private val filterTypeClickListener : OnFilterTypeClickListener
)
    : RecyclerView.Adapter<BottomSheetFilterAdapter.FilterViewHolder>(){

    var selectedFilterType : Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_filter_type_item,parent,false)

        return FilterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filterType.size
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(filterType[position])

        holder.itemView.setOnClickListener(View.OnClickListener {
            selectedFilterType = position
            filterTypeClickListener.filterTypeClick(position)
            notifyDataSetChanged()
        })
        if (selectedFilterType == position) {
            holder.itemView.constraint.setBackgroundColor(Color.parseColor("#ffffff"))
            holder.itemView.txtfilter.setTextColor(Color.parseColor("#000000"))
            holder.itemView.leftView.visibility = View.VISIBLE
            holder.itemView.rightView.visibility = View.GONE
        } else {
            holder.itemView.constraint.setBackgroundColor(Color.parseColor("#F8F8F8"))
            holder.itemView.txtfilter.setTextColor(Color.parseColor("#000000"))
            holder.itemView.leftView.visibility = View.GONE
            holder.itemView.rightView.visibility = View.VISIBLE
        }
    }


    class FilterViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {
        private val TAG = "BottomSheetFilter"
        fun bind(id : Int){
            Log.d(TAG,"Filter Type : ${view.context.resources.getString(id)}")
            view.txtfilter.text = view.context.resources.getString(id)


        }

    }
}