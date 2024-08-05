package com.example.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_article.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Column {
                    BannerImage()
                    TitleText(
                        message  = stringResource(R.string.title),
                        modifier = Modifier.padding(16.dp),
                    )
                    Paragraph(
                        message  = stringResource(R.string.header),
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    )
                    Paragraph(
                        message = stringResource(R.string.paragraph_01),
                        modifier = Modifier.padding(16.dp),
                    )
                }
            }
        }
    }
}

@Composable
fun BannerImage() {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(painter = image, contentDescription = "Banner")
}

@Composable
fun TitleText(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        fontSize = 24.sp,
        modifier = modifier,
    )
}

@Composable
fun Paragraph(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        textAlign = TextAlign.Justify,
        modifier = modifier,
    )
}


@Preview(
    showBackground = true,
    showSystemUi   = true
    )
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Column {
            BannerImage()
            TitleText(
                message  = stringResource(R.string.title),
                modifier = Modifier.padding(16.dp),
            )
            Paragraph(
                message  = stringResource(R.string.header),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Paragraph(
                message = stringResource(R.string.paragraph_01),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}