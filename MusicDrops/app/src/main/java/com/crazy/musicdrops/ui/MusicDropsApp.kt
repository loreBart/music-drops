package com.crazy.musicdrops.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.crazy.musicdrops.ui.screen.Routing
import com.crazy.musicdrops.ui.screen.Screen
import com.crazy.musicdrops.ui.screen.home.HomeScreen
import com.crazy.musicdrops.ui.screen.landing.LandingScreen
import com.crazy.musicdrops.ui.screen.login.LoginScreen
import com.crazy.musicdrops.ui.screen.login.LoginViewModel
import com.crazy.musicdrops.ui.screen.register.RegisterScreen

@Composable
fun MusicDropsApp(
    loginViewModel: LoginViewModel

) {
    val navHostController = rememberNavController()
    val navigation = remember(navHostController) {
        Routing(navHostController)
    }

    NavHost(navHostController, startDestination = Screen.Landing) {

        composable(Screen.Landing) {
            LandingScreen(navigation.goToLogin, navigation.goToRegister)
        }

        composable(Screen.Login) {
            LoginScreen(
                navigation.goToHome,
                navigation.goBack,
                loginViewModel
            )
        }

        composable(Screen.Register) {
            RegisterScreen(navigation.goToHome, navigation.goBack)
        }

        composable(
        "${Screen.Home}/{${Screen.HomeArgs.userId}}",
            arguments = listOf(navArgument(Screen.HomeArgs.userId) { type = NavType.StringType})
        ) { navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getString(Screen.HomeArgs.userId) ?: error("Invalid user id")
            HomeScreen(userId)
        }

    }


}
