package com.crazy.musicdrops.ui.screen.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel() : ViewModel() {

    val userLogger: MutableStateFlow<Boolean> = MutableStateFlow(false)

    suspend fun login(name: String, password: String) {


    }

}
