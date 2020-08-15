package com.e.android_movie.data.repository

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED

}

class NetworkState(val status: Status, val msg: String) {

    companion object {

        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState
        val ENDOFLIST: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS, "연결 성공")

            LOADING = NetworkState(Status.RUNNING, "연결 중")

            ERROR = NetworkState(Status.FAILED, "오류가 발생하였습니다.")

            ENDOFLIST = NetworkState(Status.FAILED, "You have reached the end")
        }
    }
}