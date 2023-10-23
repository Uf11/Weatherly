package com.example.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import com.example.task2.ui.theme.Task2Theme


data class WeatherData(val day: String, val weatherIcon: Int, val temperature: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherCardRow()
                }
            }
        }
    }
}

//@Composable
//fun ComposeArticleApp() {
//    ArticleCard(
//        title = stringResource(R.string.title_jetpack_compose_tutorial),
//        shortDescription = stringResource(R.string.compose_short_desc),
//        longDescription = stringResource(R.string.compose_long_desc),
//        imagePainter = painterResource(R.drawable.rsz_bulidings)
//    )
//}

@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Image(painter = imagePainter,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
//    change text color to orange
    Column(modifier = modifier) {
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = shortDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ComposeArticleAppPreview() {
//    Task2Theme {
//        ComposeArticleApp()
//    }
//}

@Composable
private fun WeatherCard(
    weather: WeatherData,
    cColor: Color
) {
    Box(modifier = Modifier
        .size(width = 65.dp, height = 150.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = weather.day,
                style = TextStyle(fontSize = 18.sp, color = cColor),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Icon(
                painter = painterResource(id = weather.weatherIcon),
                contentDescription = null,
                tint = cColor,
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = weather.temperature,
                style = TextStyle(fontSize = 16.sp, color = cColor),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun WeatherCardRow()
{
    val weatherData = listOf(
        WeatherData("MON", R.drawable.ic_cloudy, "75°F"),
        WeatherData("TUE", R.drawable.ic_sunny, "62°F"),
        WeatherData("WED", R.drawable.ic_cloudysun, "70°F"),
        WeatherData("THU", R.drawable.ic_sunny, "80°F"),
        WeatherData("FRI", R.drawable.ic_cloudy, "45°F")
    )
    Row (modifier = Modifier.fillMaxWidth(1f),
        horizontalArrangement = Arrangement.SpaceBetween){
        for ((index, data) in weatherData.withIndex()) {
            val cColor = if (index == 0) Color.Magenta else Color.Black
            WeatherCard(weather = data, cColor = cColor)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WeatherCardRowPreview()
{
    Task2Theme{
        WeatherCardRow()
    }
}