package com.crazy.musicdrops.ui.screen.login

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.crazy.musicdrops.R
import com.crazy.musicdrops.ui.screen.component.Branding
import com.crazy.musicdrops.ui.util.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


@Composable
fun LoginScreen(
    goToHome: (String) -> Unit = {},
    goBack: () -> Unit = {},
    loginViewModel: LoginViewModel
) {
    Scaffold(
        topBar = {
            LoginTopBar(
                topAppBarText = stringResource(id = R.string.label_sign_in),
                onBackPressed = { goBack() }
            )
        },
        content = {
            LoginScreenContent(loginViewModel)
        }
    )
}

@Composable
fun LoginScreenContent(loginViewModel: LoginViewModel) {
    // email
    val invalidMessage = stringResource(R.string.message_invalid_email)
    val invalidEmptyMessage = stringResource(R.string.message_invalid_empty_email)
    val emailState = remember { EmailState(invalidMessage, invalidEmptyMessage) }
    // password
    val invalidPasswordMessage = stringResource(R.string.message_invalid_password)
    val invalidEmptyPasswordMessage = stringResource(R.string.message_invalid_empty_password)
    val passwordFocusRequester = remember { FocusRequester() }
    val passwordState = remember { PasswordState(invalidPasswordMessage, invalidEmptyPasswordMessage) }

    val coroutineScope = rememberCoroutineScope()

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

            EmailTextField(emailState, onImeAction = {
                passwordFocusRequester.requestFocus()
            })

            Spacer(modifier = Modifier.height(16.dp))

            PasswordTextField(
                label = stringResource(id = R.string.label_password),
                passwordState = passwordState,
                imeAction = ImeAction.Done,
                onImeAction = {
                    val res = coroutineScope.launch {
                        val loginResult = loginViewModel.login(emailState.text, passwordState.text)
                    }
                },
                modifier = Modifier.focusRequester(passwordFocusRequester)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    coroutineScope.launch {
                        loginViewModel.login(emailState.text, passwordState.text)
                    }
                },
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = stringResource(R.string.label_sign_in)
                )
            }

        }
    }

}

fun doLogin(email: String, password: String) {
    Log.d("###", "doLogin()")
}

@Composable
fun LoginTopBar(topAppBarText: String, onBackPressed: () -> Unit) {
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
