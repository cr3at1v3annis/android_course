package com.example.unit_2_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unit_2_project.ui.theme.Unit_2_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unit_2_ProjectTheme {
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
    var state by remember { mutableStateOf(1)}
    val imageResource = when(state) {
        1 -> R.drawable.img
        2 -> R.drawable.img_1
        3 -> R.drawable.img_2
        else -> R.drawable.img
    }
    val titleMyResource = when(state) {
        1 -> R.string.first_paint_name
        2 -> R.string.second_paint_name
        3 -> R.string.third_paint_name
        else -> R.string.first_paint_name
    }
    val authorMyResource = when(state) {
        1 -> R.string.first_paint_author
        2 -> R.string.second_paint_author
        3 -> R.string.third_paint_author
        else -> R.string.first_paint_author
    }
    val descriptionMyResource = when(state) {
        1 -> R.string.first_paint_desc
        2 -> R.string.second_paint_desc
        3 -> R.string.third_paint_desc
        else -> R.string.first_paint_desc
    }
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(imageResource), contentDescription = stringResource(descriptionMyResource), modifier.weight(3.0f).height(400.dp).width(305.dp))
        Text(text= stringResource(titleMyResource), modifier.padding(16.dp).weight(1.0f), fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(text= stringResource(authorMyResource), modifier.padding(8.dp).weight(1.0f), fontSize = 20.sp)
        Row(modifier.weight(1.0f), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {if (state > 1) state--}, modifier.padding(start = 5.dp, end = 5.dp)) {
                Text(text="Previous")
            }
            Button(onClick = {if (state < 3) state++}, modifier.padding(start = 5.dp, end = 5.dp)) {
                Text(text="Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Unit_2_ProjectTheme {
        Greeting()
    }
}