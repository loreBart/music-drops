package com.crazy.musicdrops.ui.screen

import androidx.navigation.NavHostController

object Screen {
    const val Landing = "Landing"
    const val Home = "home"
    const val Login = "login"
    const val Register = "register"

    object HomeArgs {
        const val userId = "userId"
    }

}

class Routing(navHostController: NavHostController) {

    val goToHome: (String) -> Unit = { userId ->
        navHostController.navigate("${Screen.Home}/$userId")
    }

    val goToLogin: () -> Unit = {
        navHostController.navigate(Screen.Login)
    }

    val goToRegister: () -> Unit = {
        navHostController.navigate(Screen.Register)
    }

    val goBack: () -> Unit = {
        navHostController.popBackStack()
    }

}
