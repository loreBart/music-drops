package com.crazy.musicdrops.ui.screen.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crazy.musicdrops.R
import com.crazy.musicdrops.ui.screen.component.Branding
import com.crazy.musicdrops.ui.theme.MusicDropsTheme
import com.crazy.musicdrops.ui.util.*


@Composable
fun RegisterScreen(goToHome: (String) -> Unit = {}, goBack: () -> Unit = {}) {
    Scaffold(
        topBar = {
            RegisterTopBar(
                topAppBarText = stringResource(id = R.string.label_register),
                onBackPressed = { goBack() }
            )
        },
        content = {
            RegisterScreenContent()
        }
    )

}

fun doRegister(email: String, password: String) {

}

@Preview
@Composable
fun LoginScreenPreview() {
    MusicDropsTheme {
        RegisterScreen()
    }
}

@Composable
fun RegisterScreenContent() {
    // email
    val invalidMessage = stringResource(R.string.message_invalid_email)
    val invalidEmptyMessage = stringResource(R.string.message_invalid_empty_email)
    val emailState = remember { EmailState(invalidMessage, invalidEmptyMessage) }
    // password
    val invalidPasswordMessage = stringResource(R.string.message_invalid_password)
    val invalidEmptyPasswordMessage = stringResource(R.string.message_invalid_empty_password)
    val passwordState = remember { PasswordState(invalidPasswordMessage, invalidEmptyPasswordMessage) }
    val passwordFocusRequest = remember { FocusRequester() }
    // password repeat
    val invalidPasswordRepeatMessage = stringResource(R.string.message_invalid_password_repeat)
    val passwordRepeatState = remember {
        ConfirmPasswordState(passwordState,
                             invalidPasswordRepeatMessage) }
    val passwordRepeatFocusRequest = remember { FocusRequester() }

    Column {
        Branding(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            false
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 48.dp, top = 24.dp, end = 48.dp, bottom = 64.dp)
        ) {

            EmailTextField(emailState, onImeAction = { passwordFocusRequest.requestFocus() })

            Spacer(modifier = Modifier.height(16.dp))

            PasswordTextField(
                label = stringResource(id = R.string.label_password),
                passwordState = passwordState,
                imeAction = ImeAction.Next,
                onImeAction = { passwordRepeatFocusRequest.requestFocus() },
                modifier = Modifier.focusRequester(passwordFocusRequest)
            )

            Spacer(modifier = Modifier.height(16.dp))

            PasswordTextField(
                label = stringResource(id = R.string.label_repeat_password),
                passwordState = passwordRepeatState,
                imeAction = ImeAction.Next,
                onImeAction = { doRegister("", "") },
                modifier = Modifier.focusRequester(passwordRepeatFocusRequest)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { doRegister("", "") },
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.label_register)
                )
            }

        }
    }

}

@Composable
fun RegisterTopBar(topAppBarText: String, onBackPressed: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Filled.ChevronLeft,
                    contentDescription = stringResource(id = R.string.label_back)
                )
            }
        },
        // We need to balance the navigation icon, so we add a spacer.
        actions = {
            Spacer(modifier = Modifier.width(68.dp))
        },
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp
    )
}
