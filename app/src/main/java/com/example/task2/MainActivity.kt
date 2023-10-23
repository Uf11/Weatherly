package com.example.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import com.example.task2.ui.theme.Task2Theme

data class WeatherData(val day: String, val weatherIcon: Int, val temperature: String)
val weatherData = listOf(
    WeatherData("MON", R.drawable.ic_cloudy, "75°F"),
    WeatherData("TUE", R.drawable.ic_sunny, "62°F"),
    WeatherData("WED", R.drawable.ic_cloudysun, "70°F"),
    WeatherData("THU", R.drawable.ic_sunny, "80°F"),
    WeatherData("FRI", R.drawable.ic_cloudy, "45°F")
)
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
                    Page1()
                }
            }
        }
    }
}

@Composable
fun WeatherBox(imgRes: Int){
    Box(modifier = Modifier.size(width = 1000.dp, height = 650.dp)){
        Image(painter = painterResource(id = imgRes),
                contentDescription = "Usman",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(1f)
            )
        Column {
            HeaderRow()
            statRow()
        }
    }
}
@Composable
fun HeaderRow(){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ){
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 7.dp),
                tint = Color.White
            )
            Text(
                text = "Mumbai",
                style = TextStyle(fontSize = 25.sp, color = Color.Blue),
            )
        }
        Row{
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp),
                        tint = Color.White
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_wre),
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .padding(horizontal = 7.dp),
                tint = Color.White
            )
        }
    }
}
@Composable
fun statRow(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 20.dp)
    ){
        Row{
            Text(
                text = "25",
                style = TextStyle(fontSize = 60.sp, color = Color.White),
                modifier = Modifier.padding(horizontal = 7.dp)
            )
            Column (
                modifier = Modifier.align(Alignment.CenterVertically)
            ){
                Text(
                    text = "°C",
                    style = TextStyle(fontSize = 20.sp, color = Color.Blue),
                )
                Text(
                    text = "Sunny",
                    style = TextStyle(fontSize = 20.sp, color = Color.Blue),
                )
            }
        }
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ){
            Text(
                text = "23 OCT, 2023",
                style = TextStyle(fontSize = 18.sp, color = Color.White),
            )
            Text(
                text = "02:00 PM",
                style = TextStyle(fontSize = 18.sp, color = Color.Magenta),
            )
        }
    }
}

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
    Row (modifier = Modifier
        .fillMaxWidth(1f)
        .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween){
        for ((index, data) in weatherData.withIndex()) {
            val cColor = if (index == 0) Color.Magenta else Color.Black
            WeatherCard(weather = data, cColor = cColor)
        }
    }
}


// Second Page


@Composable
fun Page1() {
    Column {
        WeatherBox(imgRes = R.drawable.bg_buildings)
        WeatherCardRow()
    }
}

@Preview
@Composable
fun Page1Preview(){
    Task2Theme {
        Page1()
    }
}