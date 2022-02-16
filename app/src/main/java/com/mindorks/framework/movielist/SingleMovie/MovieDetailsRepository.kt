package com.mindorks.framework.movielist.SingleMovie

import androidx.lifecycle.LiveData
import com.mindorks.framework.movielist.model.MovieDetails
import com.mindorks.framework.movielist.remote.TheMovieDBInterface
import com.mindorks.framework.movielist.repository.MovieDetailsNetworkDataSource
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService: TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {

    }

}