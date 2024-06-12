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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.ui.unit.sp
import com.example.exploringjetpackcompose.ui.theme.ExploringJetpackComposeTheme
import kotlinx.coroutines.delay

// Multi Select Lazy Column

data class Item(val id:Int,val name:String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExploringJetpackComposeTheme {
                val items = remember {
                    listOf(
                        Item(id = 1,name= "Item 1"),
                        Item(id = 2,name= "Item 2"),
                        Item(id = 3,name= "Item 3"),
                        Item(id = 4,name= "Item 4"),
                        Item(id = 5,name= "Item 5"),
                    )
                }
                MutliSelectLazyCol(items)
            }
        }
    }
}

@Composable
fun MutliSelectLazyCol(items:List<Item>){
    val selectedItems = remember{ mutableStateOf(setOf<Int>()) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        items(items){
            item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val currentSelected = selectedItems.value.toMutableSet()
                        if(currentSelected.contains(item.id)){
                            currentSelected.remove(item.id)
                        }
                        else{
                            currentSelected.add(item.id)
                        }
                        selectedItems.value = currentSelected
                    }
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = item.name, fontSize = 20.sp
                )
                Checkbox(
                    checked = selectedItems.value.contains(item.id),
                    onCheckedChange = {
                        val currentSelected = selectedItems.value.toMutableSet()
                        if(currentSelected.contains(item.id)){
                            currentSelected.remove(item.id)
                        }
                        else{
                            currentSelected.add(item.id)
                        }
                        selectedItems.value = currentSelected
                    }
                )
            }
        }
    }
}
