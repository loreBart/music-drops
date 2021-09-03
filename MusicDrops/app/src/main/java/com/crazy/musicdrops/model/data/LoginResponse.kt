package com.crazy.musicdrops.model.data

sealed class LoginResponse {

    data class Success(val email: String) : LoginResponse()

    data class Error(val error: Throwable) : LoginResponse()

}
