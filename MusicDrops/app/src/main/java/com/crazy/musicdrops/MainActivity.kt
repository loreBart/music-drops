package com.crazy.musicdrops

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.crazy.musicdrops.model.datastore.DataStore
import com.crazy.musicdrops.ui.MusicDropsApp
import com.crazy.musicdrops.ui.screen.login.LoginViewModel
import com.crazy.musicdrops.ui.theme.MusicDropsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicDropsTheme {
                // A surface container using the 'background' color from the theme
                MusicDropsApp(loginViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MusicDropsTheme {
        Greeting("Android")
    }
}
