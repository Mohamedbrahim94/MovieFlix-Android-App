package com.example.movieflix.movieflex.movflix.ui.Home_page

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieflix.movieflex.movflix.Adapters.PopularAdapter
import com.example.movieflix.movieflex.movflix.Adapters.TopRatedAdapter
import com.example.movieflix.R

import com.example.movieflix.movieflex.movflix.base.BaseActivity
import com.example.movieflix.databinding.ActivityMainBinding


class MainActivity : BaseActivity<HomePageViewModel, ActivityMainBinding>() {

//    var topRatedMovies: List<ResultMovie?>? = null
//    var upComingMovies: List<ResultMovie?>? = null
//    var popularMovies: List<ResultMovie?>? = null

//    var totalUpcomingPages: Int? = 0
//    var totalTopRatedPages: Int? = 0
//    var totalPopularPages: Int? = 0

//    lateinit var popularRecyclerView: RecyclerView
//    lateinit var topRatedRecyclerView: RecyclerView
//    lateinit var upComingRecyclerView: RecyclerView

    lateinit var popularAdapter: PopularAdapter
    lateinit var topRatedAdapter: TopRatedAdapter
    lateinit var upComingAdapter: TopRatedAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        findViews()
        initializePopularRecyclerViews()
        initializeUpcomingRecyclerViews()
        initializeTopRatedRecyclerViews()
        observeLiveData()
        viewModel.getPopularMovies()
        viewModel.getTopRatedMovies()
        viewModel.getupComingMovies()

//        getTopRatedMovies()
//        getPopularMovies()
//        getupComingMovies()
    }

    fun observeLiveData() {
        viewModel.topRatedMovieList.observe(this, Observer {
            topRatedAdapter.list = it
            topRatedAdapter.notifyDataSetChanged()

        })

        viewModel.upComingMovieList.observe(this, Observer {
            upComingAdapter.list = it
            upComingAdapter.notifyDataSetChanged()
        })


        viewModel.popularMoviesList.observe(this, Observer {
            popularAdapter.list = it
            popularAdapter.notifyDataSetChanged()


        })

        viewModel.showDialog.observe(this, Observer {
            if (viewModel.showDialog.value!!) {
                showDialog(title = "Error ! ", message = viewModel.message.value!!,
                    posActionName = " Ok",
                    posAction = object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            dialog?.dismiss()
                        }
                    })
                viewModel.showDialog.value = false
            }
        }
        )
    }

//    fun findViews() {
//        popularRecyclerView = findViewById<RecyclerView>(R.id.popularMoviesRecyclerView)
//        topRatedRecyclerView = findViewById<RecyclerView>(R.id.topRatedMoviesRecyclerView)
//        upComingRecyclerView = findViewById<RecyclerView>(R.id.upComingMoviesRecyclerView)
//
//    }

    fun initializePopularRecyclerViews() {
        popularAdapter = PopularAdapter(null)
        binding.popularMoviesRecyclerView.adapter = popularAdapter
        binding.popularMoviesRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    }

    fun initializeUpcomingRecyclerViews() {
        upComingAdapter = TopRatedAdapter(null)
        binding.upComingMoviesRecyclerView.adapter = upComingAdapter
        binding.upComingMoviesRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    }

    fun initializeTopRatedRecyclerViews() {
        topRatedAdapter = TopRatedAdapter(null)
        binding.topRatedMoviesRecyclerView.adapter = topRatedAdapter
        binding.topRatedMoviesRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    }


//
//    fun getTopRatedMovies() {
//        ApiManager.getWebServices().getTopRatedMovies(key = Constants.apiKey, lang = " en-US")
//            .enqueue(object : retrofit2.Callback<TopRatedMoviesResponse> {
//                override fun onResponse(
//                    call: Call<TopRatedMoviesResponse>,
//                    response: Response<TopRatedMoviesResponse>,
//                ) {
//                    if (response.isSuccessful) {
//                        topRatedMovies = response.body()!!.results!!
//                        totalTopRatedPages = response.body()!!.totalPages!!
//                        initializeTopRatedRecyclerViews()
//                    } else {
//                        showDialog(title = "Error ! ", message = response.body()!!.status_message!!,
//                            posActionName = " Ok",
//                            posAction = object : DialogInterface.OnClickListener {
//                                override fun onClick(dialog: DialogInterface?, which: Int) {
//                                    dialog?.dismiss()
//                                }
//                            })
//                    }
//                }
//
//                override fun onFailure(call: Call<TopRatedMoviesResponse>, t: Throwable) {
//                    showDialog(title = "Error ! ", message = t.localizedMessage,
//                        posActionName = " Ok",
//                        posAction = object : DialogInterface.OnClickListener {
//                            override fun onClick(dialog: DialogInterface?, which: Int) {
//                                dialog?.dismiss()
//                            }
//                        })
//                }
//            })
//    }
//
//
//    fun getupComingMovies() {
//        ApiManager.getWebServices().getUpcomingMovies(key = Constants.apiKey, lang = " en-US")
//            .enqueue(object : retrofit2.Callback<UpcomingMovieResponse> {
//                override fun onResponse(
//                    call: Call<UpcomingMovieResponse>,
//                    response: Response<UpcomingMovieResponse>,
//                ) {
//                    if (response.isSuccessful) {
//                        upComingMovies = response.body()!!.results!!
//                        totalUpcomingPages = response.body()!!.totalPages!!
//                        initializeUpcomingRecyclerViews()
//
//                    } else {
//                        showDialog(title = "Error ! ", message = response.body()!!.status_message!!,
//                            posActionName = " Ok",
//                            posAction = object : DialogInterface.OnClickListener {
//                                override fun onClick(dialog: DialogInterface?, which: Int) {
//                                    dialog?.dismiss()
//                                }
//                            })
//                    }
//                }
//
//                override fun onFailure(call: Call<UpcomingMovieResponse>, t: Throwable) {
//                    showDialog(title = "Error ! ", message = t.localizedMessage,
//                        posActionName = " Ok",
//                        posAction = object : DialogInterface.OnClickListener {
//                            override fun onClick(dialog: DialogInterface?, which: Int) {
//                                dialog?.dismiss()
//                            }
//                        })
//                }
//            })
//    }
//
//
//    fun getPopularMovies() {
//        ApiManager.getWebServices().getPopularMovies(key = Constants.apiKey, lang = " en-US")
//            .enqueue(object : retrofit2.Callback<PopularMoviesResponse> {
//                override fun onResponse(
//                    call: Call<PopularMoviesResponse>,
//                    response: Response<PopularMoviesResponse>,
//                ) {
//                    if (response.isSuccessful) {
//                        popularMovies = response.body()!!.results!!
//                        totalPopularPages = response.body()!!.totalPages!!
//                        initializePopularRecyclerViews()
//
//                    } else {
//                        showDialog(title = "Error ! ", message = response.body()!!.status_message!!,
//                            posActionName = " Ok",
//                            posAction = object : DialogInterface.OnClickListener {
//                                override fun onClick(dialog: DialogInterface?, which: Int) {
//                                    dialog?.dismiss()
//                                }
//                            })
//                    }
//                }
//
//                override fun onFailure(call: Call<PopularMoviesResponse>, t: Throwable) {
//                    showDialog(title = "Error ! ", message = t.localizedMessage,
//                        posActionName = " Ok",
//                        posAction = object : DialogInterface.OnClickListener {
//                            override fun onClick(dialog: DialogInterface?, which: Int) {
//                                dialog?.dismiss()
//                            }
//                        })
//                }
//            })
//    }


    fun showDialog(
        title: String? = null,
        message: String,
        posActionName: String? = null,
        posAction: DialogInterface.OnClickListener? = null,
        negActionName: String? = null,
        negAction: DialogInterface.OnClickListener? = null,
    ) {

        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        builder.setTitle(title)
        builder.setPositiveButton(posActionName, posAction)
        builder.setNegativeButton(negActionName, negAction)
        builder.show()

    }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initializeViewModel(): HomePageViewModel {
        return ViewModelProvider(this).get(HomePageViewModel::class.java)
    }


}
