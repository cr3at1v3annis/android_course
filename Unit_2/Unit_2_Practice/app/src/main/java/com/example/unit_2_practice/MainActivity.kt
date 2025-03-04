package com.example.unit_2_practice

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unit_2_practice.ui.theme.Unit_2_PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unit_2_PracticeTheme {
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
    var imageResource = when (state) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_squeeze
        4 -> R.drawable.lemon_drink
        5 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    var contentDescResource = when (state) {
        1 -> R.string.desc_lemon_tree
        2 -> R.string.desc_lemon
        3 -> R.string.desc_lemon
        4 -> R.string.desc_glass
        5 -> R.string.desc_empty_glass
        else -> R.string.desc_lemon_tree
    }
    var textResource = when (state) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        3 -> R.string.lemon
        4 -> R.string.glass_of_lemonade
        5 -> R.string.empty_glass
        else -> R.string.lemon_tree
    }
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Card(onClick = {if (state < 5) state++ else state=1}) {
            Image(painter = painterResource(imageResource), stringResource(contentDescResource))
        }
        Spacer(modifier = modifier.padding(16.dp))
        Text(text= stringResource(textResource))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Unit_2_PracticeTheme {
        Greeting()
    }
}