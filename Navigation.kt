package com.example.exploringjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exploringjetpackcompose.ui.theme.ExploringJetpackComposeTheme

// Meditation UI using Jetpack Compose

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExploringJetpackComposeTheme {
                NavGraph();
            }
        }
    }
}
/*
implementation("androidx.navigation:navigation-compose:2.4.0-alpha04")

Do it using Sealed Class
sealed class Screen(val route:String){
    object InputScreen : Screen("input_screen")
    object DetailScreen : Screen("details_screen/{detailing}/{name}")
}

"input_screen" => Screen.InputScreen.route

*/

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "input_screen"){
        composable("input_screen"){
            InputScreen(navController);
        }
        composable("details_screen/{detailing}/{name}"){ // /{detailing}/{name}/{age}
            it ->
            val detail1 = it.arguments?.getString("detailing")?:" "
            val detail2 = it.arguments?.getString("name")?:" "
            DetailsScreen(
                detail1,detail2
            )
        }
    }
}

@Composable
fun InputScreen(navController : NavHostController){
    var text by remember {mutableStateOf("")}
    var text2  by remember{mutableStateOf("")};
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ){
        OutlinedTextField(
            value = text ,
            onValueChange = {text = it},
            label = {Text("Enter Details")},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = text2 ,
            onValueChange = {text2 = it},
            label = {Text("Enter Name")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate("details_screen/$text/$text2")
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Submit")
        }
    }
}

@Composable
fun DetailsScreen(details:String?,name:String){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ){
        Text(text  = "Details : $details and name is : $name", modifier = Modifier.fillMaxWidth())
    }
}
