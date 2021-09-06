package com.crazy.musicdrops.ui.util


class PasswordState(
    private val invalidPassword: String = "",
    private val invalidEmptyPassword: String = "") :
    TextFieldState() {

    override val validator: (String) -> Boolean = { password ->
        password.length > 3
    }

    override val errorFor: (String) -> String = { password ->
        if (password.isNullOrEmpty()) {
            invalidEmptyPassword
        } else {
            invalidPassword
        }

    }

}

class ConfirmPasswordState(
    private val passwordState: PasswordState,
    private val passwordConfirmationError: String = ""
) : TextFieldState() {

    override val isValid
        get() = passwordAndConfirmationValid(passwordState.text, text)

    override fun getError(): String? {
        return if (showErrors()) {
            passwordConfirmationError
        } else {
            null
        }
    }


    private fun passwordAndConfirmationValid(password: String, confirmedPassword: String): Boolean {
        return passwordState.validator(password) && password == confirmedPassword
    }

}
