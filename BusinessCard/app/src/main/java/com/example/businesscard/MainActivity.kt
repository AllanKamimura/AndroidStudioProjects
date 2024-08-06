package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

val MyAppIcons = Icons.Rounded

@Composable
fun BusinessCard(modifier: Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))

        MainLogo(
            name = stringResource(R.string.full_name),
            title = stringResource(R.string.person_title),
            modifier = Modifier)
        Spacer(modifier = Modifier.weight(1f))

        ContactInfo(
            icon = MyAppIcons.Delete,
            text = stringResource(R.string.phone_number),
            modifier = Modifier)
        ContactInfo(
            icon = MyAppIcons.Menu,
            text = stringResource(R.string.social_media),
            modifier = Modifier)
        ContactInfo(
            icon = MyAppIcons.LocationOn,
            text = stringResource(R.string.email_address),
            modifier = Modifier)
        Spacer(modifier = Modifier.weight(0.2f))

    }

}

@Composable
fun MainLogo(name: String, title: String, modifier: Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo")

        Text(
            text = name,
            fontSize = 30.sp,
        )
        Text(text = title)
    }
}

@Composable
fun ContactInfo(icon: ImageVector, text: String, modifier: Modifier) {
    Row (
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ){
        Icon(icon, contentDescription = null)
        Text(text,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp)
                .width(200.dp)
        )
    }
}
@Preview(
    showBackground = true,
    showSystemUi   = true,
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(modifier = Modifier)
    }
}