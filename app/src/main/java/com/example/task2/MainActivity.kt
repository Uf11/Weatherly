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

@Composable
fun Task1Problem1(){
    Column (modifier = Modifier.background(Color.White)){
        Image(painter = painterResource(R.drawable.bg_task1p1),
            contentDescription = null)
        Text(
            text = "Jetpack Compose tutorial",
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            modifier = Modifier.padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )

    }
}
@Preview
@Composable
fun Task1Problem1Preview(){
    Task2Theme {
        Task1Problem1()
    }
}

@Composable
fun Task1Problem2(){

}

@Preview
@Composable
fun Task1Problem2Preview(){
    Task2Theme {
        Task1Problem2()
    }
}

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
                    Main()
                }
            }
        }
    }
}

@Composable
private fun WeatherBox(imgRes: Int){
    Box(modifier = Modifier.size(width = 1000.dp, height = 650.dp)){
        Image(painter = painterResource(id = imgRes),
                contentDescription = "Usman",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(1f)
            )
        Column {
            HeaderRow()
            StatRow()
        }
    }
}
@Composable
private fun HeaderRow(){
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
private fun StatRow(){
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
private fun WeatherCardRow()
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

@Composable
fun Task2Page1() {
    Column {
        WeatherBox(imgRes = R.drawable.bg_buildings)
        WeatherCardRow()
    }
}

@Preview
@Composable
fun Task2Page1Preview(){
    Task2Theme {
        Task2Page1()
    }
}

// page 2
@Composable
private fun HeaderRowPage2() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(1f)
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
            )
            Text(
                text = "LOCATIONS",
                style = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
        )
    }
}

@Composable
private fun TopCompPage2(){
    Row {
        Box(modifier = Modifier
            .background(Color.White)
            .size(275.dp, 275.dp)) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HeaderRowPage2()
                Text(
                    text = "You are currently getting results for popular places of India",
                    style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier.padding(top = 20.dp)
                )
                ElevatedButton(
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Choose Place")
                }
            }
        }
        Box(modifier = Modifier
            .background(Color.LightGray)
            .size(275.dp, 275.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Add Place",
                    style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .padding(end = 10.dp, top = 20.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
private fun CityCard(data : CityWeatherData, bColor: Color, cColor: Color) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(1f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(bColor)
                .padding(vertical = 25.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = data.city,
                    style = TextStyle(fontSize = 25.sp)
                )
                Text(
                    text = data.humidity,
                    style = TextStyle(fontSize = 20.sp, color = Color.LightGray),
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Text(
                text = data.temperature + ", " + data.weatherCondition,
                style = TextStyle(fontSize = 20.sp, color = cColor)
            )
        }

    }
}

data class CityWeatherData(
    val city: String,
    val temperature: String,
    val weatherCondition: String,
    val humidity: String
)
val CityweatherData = listOf(
    CityWeatherData("Mumbai", "28", "Sunny", "Humidity: 51%"),
    CityWeatherData("Indore", "24", "Smoke", "Humidity: 35%"),
    CityWeatherData("Bhopal", "21", "Clear", "Humidity: 35%")
)

@Composable
private fun CityCardsColumn() {
    Column (modifier = Modifier
        .fillMaxHeight(1f)
        .background(Color.White)){
        for ((index, city) in CityweatherData.withIndex()) {
            val bgColor = if (index == 0) Color.Blue else Color.White
            val textColor = if (index == 0) Color.Magenta else Color.Blue
            CityCard(data = city, bColor = bgColor, cColor = textColor)
        }
    }
}

@Composable
fun Task2Page2() {
    Column {
        TopCompPage2()
        CityCardsColumn()
    }
}
@Preview
@Composable
fun Task2Page2Preview() {
    Task2Theme {
        Task2Page2()
    }
}

@Composable
fun Main(){
    Task2Page1()
    Task2Page2()
}
