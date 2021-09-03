package com.crazy.musicdrops.backend.data.code

sealed class Result {
    // Ok
    data class Ok(val msg: String = "") : Result()

    data class Error(val message: String = "",
                     val throwable: Throwable? = null) : Result()
}