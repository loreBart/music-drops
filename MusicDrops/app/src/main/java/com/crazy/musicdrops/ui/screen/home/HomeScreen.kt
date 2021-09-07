package com.crazy.musicdrops.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

@Composable
fun HomeScreen(userId: String) {
    Box(
        modifier = Modifier.fillMaxSize().background(
            color = Color.Cyan
        )
    )
}
