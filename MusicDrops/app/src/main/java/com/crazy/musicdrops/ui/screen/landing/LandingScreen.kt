package com.crazy.musicdrops.ui.screen.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crazy.musicdrops.R
import com.crazy.musicdrops.ui.screen.component.Branding
import com.crazy.musicdrops.ui.theme.MusicDropsTheme


@Composable
fun LandingScreen(
    onLoginClicked: () -> Unit = {},
    onRegisterClicked: () -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Surface {
        Column {
            Branding(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)

            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 48.dp, top = 24.dp, end = 48.dp, bottom = 48.dp)
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onLoginClicked
                ) {
                    Text(
                        text = stringResource(R.string.label_sign_in)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Surface {
                    CompositionLocalProvider(
                        LocalContentAlpha provides ContentAlpha.medium
                    ) {
                        Text(
                            text = stringResource(R.string.label_or),
                            style = MaterialTheme.typography.subtitle2,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,

                            )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(
                    onClick = onRegisterClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.label_register)
                    )
                }

            }
        }

    }

}

@Preview
@Composable
fun LandingScreenPreview() {
    MusicDropsTheme {
        LandingScreen()
    }
}
