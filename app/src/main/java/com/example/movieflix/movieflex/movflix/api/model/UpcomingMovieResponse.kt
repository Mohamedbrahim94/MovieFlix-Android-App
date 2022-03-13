package com.example.movieflix.movieflex.movflix.api.model

import com.example.movieflix.movieflex.movflix.api.model.Dates
import com.example.movieflix.movieflex.movflix.api.model.ResultMovie
import com.google.gson.annotations.SerializedName

data class UpcomingMovieResponse(
    @field:SerializedName("dates")
    val dates: Dates? = null,
    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<ResultMovie?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null,


    @field:SerializedName("status_code")
    val status_code: Int? = null,

    @field:SerializedName("status_message")
    val status_message: String? = null,

    @field:SerializedName("success")
    val success: Boolean? = null







)
