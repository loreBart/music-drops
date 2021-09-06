package com.crazy.musicdrops.ui.util

import java.util.regex.Pattern

// Consider an email valid if there's some text before and after a "@"
private const val EMAIL_VALIDATION_REGEX = "^(.+)@(.+)\$"

class EmailState(private val invalidMessage: String = "",
                 private val invalidEmptyMessage: String = "") :
    TextFieldState()
{

    override val validator: (String) -> Boolean = { email ->
        Pattern.matches(EMAIL_VALIDATION_REGEX, email)
    }

    override val errorFor: (String) -> String = { email ->
        if (email.isNullOrEmpty()) {
            invalidEmptyMessage
        } else {
            "$invalidMessage $email"
        }
    }

}
