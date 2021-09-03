package com.crazy.musicdrops.ui.screen.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RegisterScreen(
    onRegisterClicked: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize().background(
        color = Color.Blue
    )) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = onRegisterClicked
            ) {
                Text(
                    text = "Register"
                )
            }

        }

    }

}
