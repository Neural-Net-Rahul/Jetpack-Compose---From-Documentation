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
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.exploringjetpackcompose.ui.theme.ExploringJetpackComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App();
        }
    }
}

@Composable
fun App(){
    val counter = remember {mutableIntStateOf(0)};
    LaunchedEffect(key1 = Unit){
        delay(2000);
        counter.intValue = 10;
    }
    Counter(counter.intValue);
}

@Composable
fun Counter(value:Int){
    val state = rememberUpdatedState(newValue = value)
    LaunchedEffect(key1 = Unit){
        delay(5000)
        Log.d("Message",state.value.toString());
    }
    Text(
        text = value.toString(),
        fontSize = 80.sp
    );
}


// Suppose we remove state and instead of state.value we write value

// Then execution will be =>

/*
1. counter = 0
2. Counter(0) will be called
3. LaunchedEffect() function will be called
4. So inside LaunchedEffect() value will become 0
5. Text will show 0
6. After 2s,counter = 10
7. Counter(10)
8. LaunchedEffect will not be called again.
9. Text shown will be 10
10. But Log.d will show the message 0, here it is gone wrong.
11. On 0s, text = 0, On 2s, text = 10, On 5s, log->text  = 0
*/

// Else execution will be =>

/*
1. counter = 0
2. Counter(0) will be called
3. LaunchedEffect() function will be called
4. So inside LaunchedEffect() value will become 0
5. Text will show 0
6. After 2s,counter = 10
7. Counter(10)
8. LaunchedEffect will not be called again but it will take up new value.
9. Text shown will be 10
10. Log.d will show the message 10
11. On 0s, text = 0, On 2s, text = 10, On 5s, log->text  = 10
*/
