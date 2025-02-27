package com.example.unit_1_practice

import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unit_1_practice.ui.theme.Unit_1_PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Unit_1_PracticeTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ThirdTask(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
            Unit_1_PracticeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ThirdTask()
                }
            }
        }
    }
}

@Composable
fun FirstTask(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(R.drawable.bg_compose_background), null)
        Text(text = stringResource(R.string.first_string), fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(text = stringResource(R.string.second_string), modifier = Modifier.padding(start = 16.dp, end = 16.dp), textAlign = TextAlign.Justify)
        Text(text = stringResource(R.string.third_string), modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}

@Composable
fun SecondTask(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(R.drawable.ic_task_completed), null)
        Text(text = stringResource(R.string.fourth_string), modifier = Modifier.padding(top=24.dp, bottom=8.dp), fontWeight = FontWeight.Bold)
        Text(text = stringResource(R.string.fifth_string), fontSize = 24.sp)
    }
}

@Composable
fun ThirdTask(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier = modifier.weight(1.0f)) {
            Card(modifier = modifier.weight(1.0f), colors = CardColors(
                colorResource(R.color.color3_1), colorResource(R.color.black), colorResource(R.color.color3_1), colorResource(R.color.color3_1))) {
                Text(text= stringResource(R.string.task3_1))
                Text(text= stringResource(R.string.task3_2))

            }
            Card(modifier = modifier.weight(1.0f), colors = CardColors(
                colorResource(R.color.color3_2), colorResource(R.color.black), colorResource(R.color.color3_1), colorResource(R.color.color3_1))){
                Text(text= stringResource(R.string.task3_3))
                Text(text= stringResource(R.string.task3_4))
            }
        }
        Row(modifier = modifier.weight(1.0f)) {
            Card(modifier = modifier.weight(1.0f), colors = CardColors(
                    colorResource(R.color.color3_3), colorResource(R.color.black), colorResource(R.color.color3_1), colorResource(R.color.color3_1))){
                Text(text= stringResource(R.string.task3_5))
                Text(text= stringResource(R.string.task3_6))

            }
            Card(modifier = modifier.weight(1.0f), colors = CardColors(
                colorResource(R.color.color3_4), colorResource(R.color.black), colorResource(R.color.color3_1), colorResource(R.color.color3_1))){
                Text(text= stringResource(R.string.task3_7))
                Text(text= stringResource(R.string.task3_8))
            }
        }
    }
}

@Composable
fun ThirdTaskSecondVariance(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier = modifier.weight(1.0f)) {
            CustomCard(modifier.weight(1.0f), title = stringResource(R.string.task3_1), description = stringResource(R.string.task3_2), color = R.color.color3_1 )
            CustomCard(modifier.weight(1.0f), title = stringResource(R.string.task3_3), description = stringResource(R.string.task3_4), color = R.color.color3_2 )
        }
        Row(modifier = modifier.weight(1.0f)) {
            CustomCard(modifier.weight(1.0f), title = stringResource(R.string.task3_5), description = stringResource(R.string.task3_6), color = R.color.color3_3 )
            CustomCard(modifier.weight(1.0f), title = stringResource(R.string.task3_7), description = stringResource(R.string.task3_8), color = R.color.color3_4 )
        }
    }
}
@Composable
fun CustomCard(modifier: Modifier, title: String, description: String, color : Int) {
    Column(
        modifier = modifier.fillMaxHeight().background(colorResource(color)).padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = title, modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold)
        Text(text = description)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Unit_1_PracticeTheme {
        ThirdTaskSecondVariance()
    }
}