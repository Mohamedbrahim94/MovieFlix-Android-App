package com.example.movieflix.movieflex.movflix.Adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movieflix.movieflex.movflix.base.Constants

@BindingAdapter("android:urlToImageBackGround")
fun setImageFromUrlForPopular(image: ImageView, url: String) {
    Glide.with(image).load(Constants.firstPartOfUrlForPopularBackGround + url).into(image)


}
