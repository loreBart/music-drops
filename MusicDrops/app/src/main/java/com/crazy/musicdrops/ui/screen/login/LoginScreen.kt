package com.crazy.musicdrops.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crazy.musicdrops.R
import com.crazy.musicdrops.ui.screen.Routing
import com.crazy.musicdrops.ui.screen.component.Branding
import com.crazy.musicdrops.ui.theme.*
import com.crazy.musicdrops.ui.util.EmailState
import com.crazy.musicdrops.ui.util.PasswordState
import com.crazy.musicdrops.ui.util.TextFieldError
import com.crazy.musicdrops.ui.util.TextFieldState


@Composable
fun LoginScreen(goToHome: (String) -> Unit = {}, goBack: () -> Unit = {}) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    val emailState = remember { EmailState() }
    val passwordFocusRequest = remember { FocusRequester() }
    val passwordState = remember { PasswordState() }



    Scaffold(
        topBar = {
            LoginTopBar(
                topAppBarText = stringResource(id = R.string.label_sign_in),
                onBackPressed = { goBack() }
            )
        },
        content = {
            LoginScreenContent()
        }
    )

}

fun doLogin(email: String, password: String) {

}

@Preview
@Composable
fun LoginScreenPreview() {
    MusicDropsTheme {
        LoginScreen()
    }
}

@Composable
fun LoginScreenContent() {
    val emailState = remember { EmailState() }
    val passwordFocusRequest = remember { FocusRequester() }
    val passwordState = remember { PasswordState() }

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

            Email(emailState, onImeAction = { passwordFocusRequest.requestFocus() })

            Spacer(modifier = Modifier.height(16.dp))

            Password(
                label = stringResource(id = R.string.label_password),
                passwordState = passwordState,
                imeAction = ImeAction.Next,
                onImeAction = { doLogin("", "") },
                modifier = Modifier.focusRequester(passwordFocusRequest)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { doLogin("", "") }
            ) {
                Text(
                    text = stringResource(R.string.label_sign_in)
                )
            }

        }
    }

}


@Composable
fun Email(
    emailState: TextFieldState = remember { EmailState() },
    imeAction: ImeAction = ImeAction.Next,
    onImeAction: () -> Unit = {}
) {
    OutlinedTextField(
        value = emailState.text,
        onValueChange = {
            emailState.text = it
        },
        label = {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = stringResource(id = R.string.label_email),
                    style = MaterialTheme.typography.body2
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                emailState.onFocusChange(focusState.isFocused)
                if (!focusState.isFocused) {
                    emailState.enableShowErrors()
                }
            },
        textStyle = MaterialTheme.typography.body2,
        isError = emailState.showErrors(),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = imeAction),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
            }
        )
    )

    emailState.getError()?.let { error -> TextFieldError(textError = error) }
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

@Composable
fun Password(
    label: String,
    passwordState: TextFieldState,
    modifier: Modifier = Modifier,
    imeAction: ImeAction = ImeAction.Done,
    onImeAction: () -> Unit = {}
) {
    val showPassword = remember { mutableStateOf(false) }
    OutlinedTextField(
        value = passwordState.text,
        onValueChange = {
            passwordState.text = it
            passwordState.enableShowErrors()
        },
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                passwordState.onFocusChange(focusState.isFocused)
                if (!focusState.isFocused) {
                    passwordState.enableShowErrors()
                }
            },
        textStyle = MaterialTheme.typography.body2,
        label = {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.body2
                )
            }
        },
        trailingIcon = {
            if (showPassword.value) {
                IconButton(onClick = { showPassword.value = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = stringResource(id = R.string.label_password_hide)
                    )
                }
            } else {
                IconButton(onClick = { showPassword.value = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = stringResource(id = R.string.label_password_show)
                    )
                }
            }
        },
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        isError = passwordState.showErrors(),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = imeAction),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
            }
        )
    )

    passwordState.getError()?.let { error -> TextFieldError(textError = error) }
}

