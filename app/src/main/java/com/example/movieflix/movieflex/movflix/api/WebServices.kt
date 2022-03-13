package com.example.movieflix.movieflex.movflix.api

import com.example.movieflix.movieflex.movflix.api.model.PopularMoviesResponse
import com.example.movieflix.movieflex.movflix.api.model.TopRatedMoviesResponse
import com.example.movieflix.movieflex.movflix.api.model.UpcomingMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("movie/top_rated")
     fun getTopRatedMovies(
        @Query("api_key") key: String,
        @Query("Language") lang: String,
        @Query("page") page: Int = 1,
    ): Call<TopRatedMoviesResponse>

    @GET("movie/upcoming")
     fun getUpcomingMovies(
        @Query("api_key") key: String,
        @Query("Language") lang: String,
        @Query("page") page: Int = 1,
    ): Call<UpcomingMovieResponse>

    @GET("movie/popular")
     fun getPopularMovies(
        @Query("api_key") key: String,
        @Query("Language") lang: String,
        @Query("page") page: Int = 1,
    ): Call<PopularMoviesResponse>


}