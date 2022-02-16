package com.mindorks.framework.movielist.repository

import androidx.lifecycle.MutableLiveData
import com.mindorks.framework.movielist.remote.TheMovieDBInterface
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsNetworkDataSource(private val apiService: TheMovieDBInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState = MutableLiveData<NetworkState>

}