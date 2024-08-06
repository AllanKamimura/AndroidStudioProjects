package com.example.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task_manager.ui.theme.TaskmanagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskmanagerTheme {
                Column (
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ImageLogo()
                    Text(
                        text       = stringResource(R.string.completed_text),
                        modifier   = Modifier.padding(top = 24.dp, bottom = 8.dp),
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text     = stringResource(R.string.nice_work),
                        fontSize = 16.sp,
                    )
                }
            }
        }
    }
}

@Composable
fun ImageLogo() {
    Image(
        painter = painterResource(R.drawable.ic_task_completed),
        contentDescription = null
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    TaskmanagerTheme {
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ImageLogo()
            Text(
                text       = stringResource(R.string.completed_text),
                modifier   = Modifier.padding(top = 24.dp, bottom = 8.dp),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text     = stringResource(R.string.nice_work),
                fontSize = 16.sp,
            )
        }
    }
}