package com.example.movieflix.movieflex.movflix.ui.Home_page

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieflix.movieflex.movflix.api.ApiManager
import com.example.movieflix.movieflex.movflix.api.model.PopularMoviesResponse
import com.example.movieflix.movieflex.movflix.api.model.ResultMovie
import com.example.movieflix.movieflex.movflix.api.model.TopRatedMoviesResponse
import com.example.movieflix.movieflex.movflix.api.model.UpcomingMovieResponse
import com.example.movieflix.movieflex.movflix.base.Constants
import retrofit2.Call
import retrofit2.Response

class HomePageViewModel : ViewModel() {

    var topRatedMovieList = MutableLiveData<List<ResultMovie?>?>()
    var upComingMovieList = MutableLiveData<List<ResultMovie?>?>()
    var popularMoviesList = MutableLiveData<List<ResultMovie?>?>()
    var showDialog = MutableLiveData<Boolean>(false)
    val message = MutableLiveData<String>("")


    fun getTopRatedMovies() {
        ApiManager.getWebServices().getTopRatedMovies(key = Constants.apiKey, lang = " en-US")
            .enqueue(object : retrofit2.Callback<TopRatedMoviesResponse> {
                override fun onResponse(
                    call: Call<TopRatedMoviesResponse>,
                    response: Response<TopRatedMoviesResponse>,
                ) {
                    if (response.isSuccessful) {
//                        topRatedMovies = response.body()!!.results!!
//                        totalTopRatedPages = response.body()!!.totalPages!!
//                        initializeTopRatedRecyclerViews()

                        topRatedMovieList.value = response.body()!!.results

                    } else {
//                        showDialog(title = "Error ! ", message = response.body()!!.status_message!!,
//                            posActionName = " Ok",
//                            posAction = object : DialogInterface.OnClickListener {
//                                override fun onClick(dialog: DialogInterface?, which: Int) {
//                                    dialog?.dismiss()
//                                }
//                            })
                        message.value = response.body()!!.status_message!!
                        showDialog.value = true


                    }
                }

                override fun onFailure(call: Call<TopRatedMoviesResponse>, t: Throwable) {
//                    showDialog(title = "Error ! ", message = t.localizedMessage,
//                        posActionName = " Ok",
//                        posAction = object : DialogInterface.OnClickListener {
//                            override fun onClick(dialog: DialogInterface?, which: Int) {
//                                dialog?.dismiss()
//                            }
//                        })
                    message.value = t.localizedMessage

                    showDialog.value = true

                }
            })
    }


    fun getupComingMovies() {
        ApiManager.getWebServices().getUpcomingMovies(key = Constants.apiKey, lang = " en-US")
            .enqueue(object : retrofit2.Callback<UpcomingMovieResponse> {
                override fun onResponse(
                    call: Call<UpcomingMovieResponse>,
                    response: Response<UpcomingMovieResponse>,
                ) {
                    if (response.isSuccessful) {
//                        upComingMovies = response.body()!!.results!!
//                        totalUpcomingPages = response.body()!!.totalPages!!
//                        initializeUpcomingRecyclerViews()

                        upComingMovieList.value = response.body()!!.results

                    } else {
//                        showDialog(title = "Error ! ", message = response.body()!!.status_message!!,
//                            posActionName = " Ok",
//                            posAction = object : DialogInterface.OnClickListener {
//                                override fun onClick(dialog: DialogInterface?, which: Int) {
//                                    dialog?.dismiss()
//                                }
//                            })
                        message.value = response.body()!!.status_message!!
                        showDialog.value = true


                    }
                }

                override fun onFailure(call: Call<UpcomingMovieResponse>, t: Throwable) {
//                    showDialog(title = "Error ! ", message = t.localizedMessage,
//                        posActionName = " Ok",
//                        posAction = object : DialogInterface.OnClickListener {
//                            override fun onClick(dialog: DialogInterface?, which: Int) {
//                                dialog?.dismiss()
//                            }
//                        })
                    message.value = t.localizedMessage
                    showDialog.value = true


                }
            })
    }


    fun getPopularMovies() {
        ApiManager.getWebServices().getPopularMovies(key = Constants.apiKey, lang = " en-US")
            .enqueue(object : retrofit2.Callback<PopularMoviesResponse> {
                override fun onResponse(
                    call: Call<PopularMoviesResponse>,
                    response: Response<PopularMoviesResponse>,
                ) {
                    if (response.isSuccessful) {
//                        popularMovies = response.body()!!.results!!
//                        totalPopularPages = response.body()!!.totalPages!!
//                        initializePopularRecyclerViews()

                        popularMoviesList.value = response.body()!!.results

                    } else {
//                        showDialog(title = "Error ! ", message = response.body()!!.status_message!!,
//                            posActionName = " Ok",
//                            posAction = object : DialogInterface.OnClickListener {
//                                override fun onClick(dialog: DialogInterface?, which: Int) {
//                                    dialog?.dismiss()
//                                }
//                            })
                        message.value = response.body()!!.status_message!!
                        showDialog.value = true



                    }
                }

                override fun onFailure(call: Call<PopularMoviesResponse>, t: Throwable) {
//                    showDialog(title = "Error ! ", message = t.localizedMessage,
//                        posActionName = " Ok",
//                        posAction = object : DialogInterface.OnClickListener {
//                            override fun onClick(dialog: DialogInterface?, which: Int) {
//                                dialog?.dismiss()
//                            }
//                        })
                    message.value = t.localizedMessage

                    showDialog.value = true


                }
            })
    }
}


