package com.example.minichallange2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.minichallange2.Model.DataFilmResponseItem
import com.example.minichallange2.R
import kotlinx.android.synthetic.main.item_film.view.*

class AdapterFIlm() : RecyclerView.Adapter<AdapterFIlm.ViewHolder>() {

    private var datafilm : List<DataFilmResponseItem>? = null

    fun setDataFilm(film : List<DataFilmResponseItem>){
        this.datafilm = film
    }

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val result = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return ViewHolder(result)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvjudul.text = datafilm!![position].judul
        holder.itemView.tvdirecto.text = datafilm!![position].director
        holder.itemView.tvdiscripsi.text = datafilm!![position].description

        Glide.with(holder.itemView.context)
            .load(datafilm!![position].image)
            .into(holder.itemView.img_view)
    }

    override fun getItemCount(): Int {
        if (datafilm == null){
            return 0
        } else{
            return datafilm!!.size
        }
    }
}