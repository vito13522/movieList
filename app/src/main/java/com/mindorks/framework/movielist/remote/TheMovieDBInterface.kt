package com.mindorks.framework.movielist.remote

import com.mindorks.framework.movielist.model.MovieDetails
import com.mindorks.framework.movielist.model.Movies
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface TheMovieDBInterface {

    @GET("3/movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id")id: Int, @Query("api_key")sort: String): Single<MovieDetails>

}