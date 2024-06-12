package com.example.exploringjetpackcompose

import android.os.Bundle
import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.style.TextMotion.Companion.Animated
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exploringjetpackcompose.ui.theme.ExploringJetpackComposeTheme
import kotlinx.coroutines.delay

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

@Composable
fun NavGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main_screen"){
        composable("main_screen"){
            SplashScreen(navController)
        }
        composable("detail_screen"){
            DetailScreen();
        }
    }
}

@Composable
fun SplashScreen(navController : NavHostController){
    val scale = remember { Animatable(0f)}
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 1.2f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {OvershootInterpolator(4f).getInterpolation(it)}
            )
        )
        delay(2000L)
        navController.navigate("detail_screen")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "VideoCam",
            modifier = Modifier
                .scale(scale.value)
                .size(200.dp)
        )
    }
}

@Composable
fun DetailScreen(){
    Text("Hello World",modifier = Modifier.padding(20.dp))
}
