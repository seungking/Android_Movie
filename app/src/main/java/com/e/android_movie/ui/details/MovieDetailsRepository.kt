package com.e.android_movie.ui.details

import androidx.lifecycle.LiveData
import com.e.android_movie.data.api.TheMovieDBinterface
import com.e.android_movie.data.repository.MovieDetailsNetworkDataSource
import com.e.android_movie.data.repository.NetworkState
import com.e.android_movie.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBinterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    //변수랑 아이디 받아서 영화 세부 정보 livedata 반환
    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}