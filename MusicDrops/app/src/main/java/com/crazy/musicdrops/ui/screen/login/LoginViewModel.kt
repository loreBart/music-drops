package com.crazy.musicdrops.ui.screen.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.crazy.musicdrops.model.data.LoginResponse
import com.crazy.musicdrops.model.repository.login.ILoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: ILoginRepository
) : ViewModel() {

    suspend fun login(email: String, password: String): LoginResponse {
        Log.d("###", "calling login reposinstance ${loginRepository.javaClass}")
        return loginRepository.login(email, password)
    }

}
