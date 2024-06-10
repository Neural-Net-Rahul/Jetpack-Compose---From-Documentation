package com.example.exploringjetpackcompose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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


// Text Styling

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App();
        }
    }
}

@Composable
fun App() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ){

            Text(
                text = buildAnnotatedString {
                                            withStyle(
                                                style = SpanStyle(
                                                    color = Color.Green,
                                                    fontSize = 50.sp
                                                )
                                            ){
                                                append("J");
                                            }
                    append("etpack ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green,
                            fontSize = 50.sp
                        )
                    ){
                        append("C");
                    }
                    append("ompose");
                },
                color = Color.White ,
                fontFamily = FontFamily.SansSerif ,
                fontSize = 30.sp ,
                fontStyle = FontStyle.Italic ,
                textAlign = TextAlign.Center ,
                textDecoration = TextDecoration.Underline ,
                modifier = Modifier
                    .align(Alignment.Center)
                // in the center of screen
            )

    }
}
