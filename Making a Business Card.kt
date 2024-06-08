package com.example.jetpackcompose

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Preview(showBackground = true, widthDp = 450, heightDp = 700)
@Composable
fun CallAnotherFunc(){
    BusinessCard()
}

@Composable
fun BusinessCard(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ){
        Column(
            modifier = Modifier
                .height(400.dp)
                .width(300.dp)
                .align(Alignment.Center)
                .padding(20.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 70.dp, top = 70.dp,end = 70.dp)
            )
            Text(
                text = "Jennifer Doe",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(0.dp , 10.dp , 0.dp , 5.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Android Developer Extraordinaire",
                color = Color.Green,
                fontSize = 17.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp)
        ) {
            CopiedContent(R.drawable.beach_img,"99 586 11962");
            CopiedContent(R.drawable.beach_img,"@Android Dev");
            CopiedContent(R.drawable.beach_img,"jen.doe@android.com");
        }
    }
}

@Composable
fun CopiedContent(imageId:Int,text:String){
    Row (

    ){
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
        )
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Magenta,
            modifier = Modifier
                .padding(start = 15.dp, top = 4.dp)
        )
    }
}
