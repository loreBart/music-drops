package com.crazy.musicdrops.ui.screen.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crazy.musicdrops.model.data.LoginResponse
import com.crazy.musicdrops.model.datastore.DataStore
import com.crazy.musicdrops.model.repository.login.ILoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: ILoginRepository,
    var dataStore: DataStore
) : ViewModel() {

    var autoLogin: StateFlow<Boolean> = dataStore.getBoolean("auto_login", false).stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        false
    )


    fun setAutoLogin(autoLogin: Boolean) {
        viewModelScope.launch {
            dataStore.set("auto_login", autoLogin)
        }
    }

    suspend fun login(email: String, password: String): LoginResponse {
        Log.d("###", "calling login reposinstance ${loginRepository.javaClass}")
        return loginRepository.login(email, password)
    }

}
