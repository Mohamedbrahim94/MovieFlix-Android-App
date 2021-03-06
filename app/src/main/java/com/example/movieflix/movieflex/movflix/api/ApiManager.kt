package com.example.movieflix.movieflex.movflix.api


import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager {
    companion object {
        private var retrofit: Retrofit? = null

        @Synchronized
        private fun getInstance(): Retrofit {
            if (retrofit == null) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                val keyInterceptor = Interceptor { chain: Interceptor.Chain ->
                    var original = chain.request()

                    var url: HttpUrl =
                        original.url.newBuilder()
                            .addQueryParameter("apiKey", "11a8dc4581bcfd1a710d1c4d76327a9d").build()
                    original = original.newBuilder().url(url).build()
                    // Request customization: add request headers

                    chain.proceed(original)
                }
                val lanuageInterceptor = Interceptor { chain ->
                    var original = chain.request()

                    var url: HttpUrl =
                        original.url.newBuilder().addQueryParameter("language", "en").build()
                    original = original.newBuilder().url(url).build()
                    // Request customization: add request headers

                    chain.proceed(original)
                }


                val client = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(lanuageInterceptor)
                    .addInterceptor(keyInterceptor)
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl("\n" +
                            "https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                return retrofit!!
            }
            return retrofit!!
        }

        fun getWebServices(): WebServices {
            return getInstance().create(WebServices::class.java)
        }


    }
}
