package com.example.mvvmpagingtutorial.data.repository

enum class Status{
    RUNNING,
    SUCCESS,
    FAILURE
}

class NetworkState(val status: Status,val msg : String) {

    companion object{
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState
        val ENDOFLIST: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS,"Success")
            LOADING = NetworkState(Status.RUNNING,"Running")
            ERROR = NetworkState(Status.FAILURE,"Something went wrong")
            ENDOFLIST = NetworkState(Status.FAILURE,"End of List")
        }
    }


}