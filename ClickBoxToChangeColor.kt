package com.example.exploringjetpackcompose

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


// Click Box to Color Change

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App();
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun App() {
    val color = remember {mutableStateOf(Color.Yellow)};
    Column{
        Box(
            modifier = Modifier
                .background(Color.Black)
                .width(300.dp)
                .height(300.dp)
                .clickable {
                    color.value = Color(
                        Random.nextFloat() ,
                        Random.nextFloat() ,
                        Random.nextFloat() ,
                        1f
                    )
                }
        )
        Box(
            modifier = Modifier
                .background(color.value)
                .width(300.dp)
                .height(300.dp)
        )
    }
}
