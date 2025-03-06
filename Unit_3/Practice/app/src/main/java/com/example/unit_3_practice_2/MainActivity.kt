package com.example.unit_3_practice_2

import HeroesRepository
import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unit_3_practice_2.model.Hero
import com.example.unit_3_practice_2.ui.theme.Typography
import com.example.unit_3_practice_2.ui.theme.Unit_3_Practice_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unit_3_Practice_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SuperheroItem(Hero(nameRes = R.string.hero1, descriptionRes = R.string.description1, imageRes = R.drawable.android_superhero1), modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun superheroList(listOfSuperheroes: List<Hero> = HeroesRepository.heroes, modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text=stringResource(R.string.app_name), style = Typography.displayLarge)
        LazyColumn(modifier = modifier) {
            items(listOfSuperheroes) { superhero ->
                SuperheroItem(
                    superhero = superhero,
                    modifier = Modifier.padding(8.dp)
                )
            }

        }
    }
}

@Composable
fun SuperheroItem(superhero: Hero, modifier: Modifier) {
    Row()
    {
        Column(modifier = modifier.weight(3f).align(Alignment.CenterVertically)) {
            Text(text= stringResource(superhero.nameRes), style = Typography.displayMedium)
            Text(text= stringResource(superhero.descriptionRes), style = Typography.displaySmall)
        }
        Image(painter = painterResource(superhero.imageRes), contentDescription = stringResource(superhero.nameRes), modifier.weight(1f))

    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Unit_3_Practice_2Theme {
        superheroList(modifier = Modifier)
    }
}