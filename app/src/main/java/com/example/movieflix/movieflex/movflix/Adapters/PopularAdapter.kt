package com.example.movieflix.movieflex.movflix.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieflix.R
import com.example.movieflix.movieflex.movflix.api.model.ResultMovie
import com.example.movieflix.databinding.PopularItemBinding

class PopularAdapter(var list: List<ResultMovie?>?) :
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {


    class ViewHolder(val itemBinding: PopularItemBinding) :RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(movie : ResultMovie){
            itemBinding.movie = movie

        }

//        lateinit var backgroud : ImageView
//        lateinit var poster: ImageView
//        lateinit var name : TextView
//
//        init {
//
//              backgroud = itemView.findViewById(R.id.BackgroundImageView)
//              poster = itemView.findViewById(R.id.PosterImageView)
//              name = itemView.findViewById(R.id.PopularMovNameTextView)
//        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view : PopularItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.popular_item,parent,false)
//        val view = PopularItemBinding.Databinding
//            LayoutInflater.from(parent.context).inflate(R.layout.popular_item, parent, false)
     return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = list!!.get(position)
        holder.bind(item!!)
//        holder.name.setText(item!!.title)
//        Glide.with(holder.itemView).load(Constants.firstPartOfUrl + item.posterPath)
//            .into(holder.poster)
//        Glide.with(holder.itemView).load(Constants.firstPartOfUrl + item.backdropPath)
//            .into(holder.backgroud)

    }

    override fun getItemCount(): Int {
        return list!!.size ?: 0

    }
}