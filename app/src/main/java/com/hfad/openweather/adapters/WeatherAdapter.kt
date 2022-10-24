package com.hfad.openweather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.hfad.openweather.R
import com.hfad.openweather.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class WeatherAdapter(val listener: Listener?) : ListAdapter<WeatherModel, WeatherAdapter.Holder>(Comporator()) {

    class Holder(view: View, val listener: Listener?) : RecyclerView.ViewHolder(view) {
        val binding = ListItemBinding.bind(view)
        var itemTemp:WeatherModel? = null

        init {
            itemView.setOnClickListener{
                itemTemp?.let { it1 -> listener?.onClick(it1) }
            }
        }
        fun bind(item: WeatherModel) = with(binding) {
            itemTemp = item
            tvDate.text = item.time
            tvCondition.text = item.condition
            tvTemp.text = item.currentTemp.ifEmpty { "${item.maxTemp} C / ${item.minTemp}" }
            Picasso.get().load("https:"+item.imageUrl).into(imageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent,
            false)
        return Holder(view, listener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    interface Listener{
        fun onClick(item: WeatherModel)
    }
}

class Comporator : DiffUtil.ItemCallback<WeatherModel>() {
    override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
        return oldItem == newItem

    }



}