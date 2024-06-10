package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.view.WindowManager
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import kotlin.math.roundToInt

@Composable
fun BlogCategory(img: Int, title: String, subtitle: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 10.dp)
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = subtitle,
                    fontSize = 15.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 500, widthDp = 350)
@Composable
// Column with modifier as vertical Scroll() and inside Column apply a for loop => Implementation of List View
/*
fun MyApp() {
    val state = rememberScrollState();
    Column(
        modifier = Modifier.verticalScroll(state).
        fillMaxSize()
    ) {
        for (i in 1..100) {
            Text(text = "Hello $i",
            modifier = Modifier.padding(10.dp))
        }
    }
}
*/
fun PreviewItem() {
    LazyColumn(
        content = {
            items(getCategoryList()) { item ->
                BlogCategory(img = item.img, title = item.title, subtitle = item.subtitle)
            }
        },
        horizontalAlignment = Alignment.CenterHorizontally
    )
}

data class Category(val img:Int, val title:String, val subtitle:String)

fun getCategoryList():MutableList<Category>{
    val listItems : MutableList<Category> = mutableListOf();
    listItems.add(Category(R.drawable.android_logo,"Programming1","Learn Different Languages"));
    listItems.add(Category(R.drawable.beach_img,"Programming2","Learn Different Languages"));
    listItems.add(Category(R.drawable.android_logo,"Programming3","Learn Different Languages"));
    listItems.add(Category(R.drawable.beach_img,"Programming4","Learn Different Languages"));
    listItems.add(Category(R.drawable.android_logo,"Programming5","Learn Different Languages"));
    listItems.add(Category(R.drawable.beach_img,"Programming6","Learn Different Languages"));
    listItems.add(Category(R.drawable.beach_img,"Programming7","Learn Different Languages"));
    listItems.add(Category(R.drawable.android_logo,"Programming8","Learn Different Languages"));
    listItems.add(Category(R.drawable.beach_img,"Programming9","Learn Different Languages"));
    listItems.add(Category(R.drawable.android_logo,"Programming10","Learn Different Languages"));
    return listItems;
}
