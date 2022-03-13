package com.example.movieflix.movieflex.movflix.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieflix.R
import com.example.movieflix.movieflex.movflix.api.model.ResultMovie
import com.example.movieflix.databinding.TopRatedUpcomingItemBinding

class TopRatedAdapter(var list: List<ResultMovie?>?) :
    RecyclerView.Adapter<TopRatedAdapter.viewHolder>() {


    class viewHolder(val itemBinding: TopRatedUpcomingItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        //        lateinit var topRatedPoster: ImageView
//        lateinit var name: TextView
//        init {
//            topRatedPoster = itemView.findViewById<ImageView>(R.id.TopRated_upComing_Poster)
//            name = itemView.findViewById<TextView>(R.id.MovieName)
//        }
        fun bind(movie: ResultMovie) {
            itemBinding.movie = movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view: TopRatedUpcomingItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.top_rated_upcoming_item,
                parent,
                false)
//            .inflate(R.layout.top_rated_upcoming_item, parent, false)
     return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = list!!.get(position)
        holder.bind(item!!)

//        holder.name.setText(item!!.title)
//        Glide.with(holder.itemView).load(Constants.firstPartOfUrl + item.posterPath)
//            .into(holder.topRatedPoster)

    }

    override fun getItemCount(): Int {
        return list!!.size ?: 0

    }
}