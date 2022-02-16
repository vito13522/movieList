package com.mindorks.framework.movielist.remote

import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val API_KEY = "9f27579c00bf2cac2ad7b467e86c5105"
const val BASE_URL = "https://api.themoviedb.org/"
const val POSTER_BASE_URL ="https://image.tmdb.org/t/p/w500/"

object TheMovieDBClient{

    fun getClient(): TheMovieDBInterface {
        val requestInterceptor = Interceptor { chain ->

            val url:HttpUrl = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val request: Request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheMovieDBInterface::class.java)


    }

}