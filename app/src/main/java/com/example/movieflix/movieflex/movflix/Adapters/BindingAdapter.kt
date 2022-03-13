package com.example.movieflix.movieflex.movflix.Adapters


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movieflix.movieflex.movflix.base.Constants

@BindingAdapter("android:urlToImage")
fun setImageFromUrl(image: ImageView, url: String) {
    Glide.with(image).load(Constants.firstPartOfUrl + url).into(image)

//    Glide.with(holder.itemView).load(Constants.firstPartOfUrl + item.posterPath)
////            .into(holder.topRatedPoster)




}
