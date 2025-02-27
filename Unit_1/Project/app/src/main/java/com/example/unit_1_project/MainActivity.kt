package com.example.unit_1_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.unit_1_project.ui.theme.Unit_1_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unit_1_ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier.fillMaxSize())
    {
        CustomCardOne(modifier, imageId = R.drawable.img, text_desc = stringResource(R.string.title_desc),
            title = stringResource(R.string.title), name = stringResource(R.string.name))
        CustomCardTwo(modifier, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
            stringResource(R.string.phone), stringResource(R.string.contact), stringResource(R.string.email))
    }
}
@Composable
fun CustomCardOne(modifier: Modifier, imageId: Int, text_desc : String, title: String, name : String)
{
    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(imageId), text_desc)
        Text(text = title, fontWeight = FontWeight.SemiBold)
        Text(text = name,  fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun CustomCardTwo(modifier: Modifier, imageId1: Int, imageId2: Int, imageId3: Int, phone: String,
                  contact: String, email : String)
{
    Column(modifier = modifier, verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row(modifier.padding(5.dp)) {
            Image(painterResource(imageId1), "phone", modifier.height(30.dp).width(30.dp).padding(end = 5.dp))
            Text(text=phone)
        }
        Row(modifier.padding(5.dp)) {
            Image(painterResource(imageId2), "tg", modifier.height(30.dp).width(30.dp).padding(end = 5.dp))
            Text(text=contact)
        }
        Row(modifier.padding(5.dp)) {
            Image(painterResource(imageId3), "email", modifier.height(30.dp).width(30.dp).padding(end = 5.dp))
            Text(text=email)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Unit_1_ProjectTheme {
        Greeting()
    }
}