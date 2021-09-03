package com.crazy.musicdrops.ui.screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crazy.musicdrops.R
import com.crazy.musicdrops.ui.theme.LightBlu500
import com.crazy.musicdrops.ui.theme.LightBlu700
import com.crazy.musicdrops.ui.theme.MusicDropsTheme


@Composable
fun Branding(modifier: Modifier = Modifier, hasTitle: Boolean = true) {
    val music = stringResource(R.string.label_music)
    val drops = stringResource(R.string.label_drops)
    Column(modifier.wrapContentHeight(align = Alignment.CenterVertically)) {
        Logo(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(256.dp)
                .padding(horizontal = 76.dp)
        )
        if (hasTitle) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = LightBlu700)) {
                        append("$music ")
                    }
                    withStyle(SpanStyle(color = LightBlu500)) {
                        append(drops)
                    }
                },
                color = LightBlu500,
                style = MaterialTheme.typography.h6,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            )
        }
    }

}

@Preview
@Composable
fun BrandingPreview() {
    MusicDropsTheme {
        Branding()
    }
}

@Composable
private fun Logo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.ic_logo),
        modifier = modifier,
        contentDescription = null
    )
}

@Preview
@Composable
fun LogoPreview() {
    MusicDropsTheme {
        Logo()
    }
}
