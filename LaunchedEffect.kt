package com.example.exploringjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exploringjetpackcompose.ui.theme.ExploringJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ListComposable();
            Counter();
        }
    }
}

@Composable
fun Counter(){
    val count = remember{ mutableIntStateOf(0) }
    val key = count.intValue%3 == 0
    LaunchedEffect(key1 = key){
        Log.d("Counter","Current count : ${count.intValue}")
        // 0 1 3 4 6 7 9...
    }
    Button(onClick = {count.intValue++}){
        Text("Increment count");
    }
}

@Composable
fun ListComposable()
{
    val categoryState = remember { mutableStateOf(emptyList<String>()) }
    // each time ListComposable() function is called fetchData() will be called.
    // So we want it's call to be just one time
    // so we will use LaunchedEffect
    // Everytime key1 value will be changed, every time this section will be executed.
    // First time key1 will be assigned to 1, so key1 changes to first time it will be executed
    // For second and so on, key1 is already 1, so no new assignment of 1(or Unit) so no change.
    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchData();
    }
    LazyColumn(
        content = {
            items(categoryState.value) { item ->
                 Text(text = item);
            }
        }
    )
}

fun fetchData():List<String>{
    return listOf("Apple","Banana","Orange");
}

// Launched Effect => Side Effect Handler 
// We can call composable functions many times, but we can control the execution of
// some section inside it to limited number of times/on meeting some condition using LaunchedEffect
