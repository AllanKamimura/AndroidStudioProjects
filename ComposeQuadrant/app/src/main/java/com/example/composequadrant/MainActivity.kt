package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    BigFrame()
                }
            }
        }
    }
}

@Composable
fun RectangleFrame(
    title: String,
    backgroundColor: Color,
    content: String,
    modifier: Modifier = Modifier
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(backgroundColor)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
        )
    }
}

@Composable
fun BigFrame(){
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Row(
            modifier = Modifier.weight(1f),
        ) {
            RectangleFrame(
                title = stringResource(R.string.first_title),
                backgroundColor = Color(0xFFEADDFF),
                content = stringResource(R.string.first_description),
                modifier = Modifier.weight(1f)
            )
            RectangleFrame(
                title = stringResource(R.string.second_title),
                backgroundColor = Color(0xFFD0BCFF),
                content = stringResource(R.string.second_description),
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.weight(1f),
        ) {
            RectangleFrame(
                title = stringResource(R.string.third_title),
                backgroundColor = Color(0xFFB69DF8),
                content = stringResource(R.string.third_description),
                modifier = Modifier.weight(1f)
            )
            RectangleFrame(
                title = stringResource(R.string.fourth_title),
                backgroundColor = Color(0xFFF6EDFF),
                content = stringResource(R.string.fourth_description),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        BigFrame()
    }
}