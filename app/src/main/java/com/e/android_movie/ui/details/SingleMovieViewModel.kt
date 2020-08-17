package com.e.android_movie.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.e.android_movie.data.repository.NetworkState
import com.e.android_movie.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel (private val movieRepository : MovieDetailsRepository, movieId: Int)  : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    //lazy로 늦은 초기화를 하면 앱이 시작될 때 연산을 분산시킬 수 있어 빠른 실행에 도움
    val  movieDetails : LiveData<MovieDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable,movieId)
    }

    val networkState : LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    //compositeDisposalbe 변수는 메모리를 알아서 한번에 정리
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}