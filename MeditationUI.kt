package com.example.exploringjetpackcompose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exploringjetpackcompose.BottomMenuContent
import com.example.exploringjetpackcompose.Feature
import com.example.exploringjetpackcompose.R

@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(listOf("Sweet Sleep", "Insomnia", "Depression", "Mental Stress"))
            DailyThought()
            FeatureSelection(features = listOf(
                Feature(
                    title = "Sleep Meditation",
                    R.drawable.ic_headphone
                ),
                Feature(
                    title = "Tips for Sleeping",
                    R.drawable.ic_videocam
                ),
                Feature(
                    title = "Nights Island",
                    R.drawable.ic_headphone
                ),
                Feature(
                    title = "Calming Sounds",
                    R.drawable.ic_headphone
                ),
                Feature(
                    title = "Depression Free",
                    R.drawable.ic_moon
                )
            ))
            BottomMenu(items = listOf(
                BottomMenuContent(
                    "Home",
                    R.drawable.ic_home
                ),
                BottomMenuContent(
                        "Meditate",
                        R.drawable.ic_bubble
                ),
                BottomMenuContent(
                    "Sleep",
                    R.drawable.ic_moon
                ),
                BottomMenuContent(
                    "Music",
                    R.drawable.ic_music
                ),
                BottomMenuContent(
                    "Profile",
                    R.drawable.ic_profile
                )
            ))
        }
    }
}

@Composable
fun GreetingSection(name: String = "Rahul") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp , top = 25.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Good Morning, $name",
                color = Color.White,
                fontSize = 25.sp,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = "We wish you have a good day!",
                color = Color(0xFFC2B8B7),
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .padding(end = 15.dp),
            tint = Color.White
        )
    }
}

@Composable
fun ChipSection(
    listItem: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp , top = 20.dp , bottom = 20.dp , end = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        itemsIndexed(listItem) { index, item ->
            ChipStructure(selectedChipIndex, index, item) { newIndex ->
                selectedChipIndex = newIndex
            }
        }
    }
}

@Composable
fun ChipStructure(selectedChipIndex: Int, index: Int, item: String, onSelectedChanged: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .clickable {
                onSelectedChanged(index)
            }
            .background(
                if (selectedChipIndex == index) {
                    ButtonBlue
                } else {
                    DarkerButtonBlue
                } ,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(8.dp),
    ) {
        Text(
            text = item,
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive
        )
    }
}

@Composable
fun DailyThought() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 15.dp , end = 15.dp)
            .background(
                LightRed ,
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Daily Thought",
                color = Color.White,
                fontSize = 25.sp,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .padding(start = 20.dp,end = 20.dp, bottom = 7.dp, top = 15.dp)
            )
            Text(
                text = "Meditation 3-10 min",
                color = Color(0xFFECE6E5),
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 15.dp)
            )
        }
        Box(
            modifier = Modifier
                .padding(7.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center ,
                modifier = Modifier
                    .size(60.dp) // size of the circle
                    .background(
                        color = Color.Black ,
                        shape = CircleShape
                    )
                    .padding(15.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play) ,
                    contentDescription = null ,
                    modifier = Modifier.size(30.dp) , // size of the icon
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun FeatureSelection(features : List<Feature>){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Features" ,
            fontSize = 30.sp,
            color = Color.White,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .background(
                    Color.Black , RoundedCornerShape(10.dp)
                )
                .padding(10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end=7.5.dp, bottom = 20.dp),
            modifier = Modifier
                .fillMaxHeight()
                .background(
                    Color.White ,
                    RoundedCornerShape(20.dp)
                )
        ){
            items(features.size){
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(feature : Feature) {
    Box(
        modifier = Modifier
            .padding(start = 7.5.dp,end = 7.5.dp,top = 20.dp)
    ){
        Box(
            modifier = Modifier
                .background(
                    Color.Black , RoundedCornerShape(20.dp)
                )
                .height(150.dp)
                .width(200.dp)
                .padding(20.dp)
        ){
            Text(
                text = feature.title,
                style = MaterialTheme.typography.labelMedium,
                color = Color.White,
                lineHeight = 20.sp,
                fontSize = 20.sp,
                modifier =  Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp , horizontal = 15.dp)
            )
        }
    }
}

@Composable
fun BottomMenu(
    items : List<BottomMenuContent>,
    activeHighlightColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor : Color = AquaBlue,
    initialSelectedItemIndex : Int = 0,
){
    var selectedItemIndex by remember{
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ){
        items.forEachIndexed{
            index,item->
            BottomMenuItem(item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,)
            {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item : BottomMenuContent,
    isSelected:Boolean = false,
    activeHighlightColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor : Color = AquaBlue,
    onItemClick : () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, 
        modifier = Modifier
            .clickable{
                onItemClick()
            }
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if(isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(text = item.title, color = if(isSelected) activeTextColor else inactiveTextColor)
    }
}
