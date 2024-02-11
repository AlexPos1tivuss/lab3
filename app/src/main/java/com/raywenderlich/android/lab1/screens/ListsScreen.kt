package com.raywenderlich.android.lab1.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raywenderlich.android.lab1.R
import com.raywenderlich.android.lab1.router.BackButtonHandler
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen

private val items = listOf(
    BookCategory(
        R.string.sila,
        listOf(
            R.drawable.pudge,
            R.drawable.tidehunter,
            R.drawable.bristleback
        )
    ),
    BookCategory(
        R.string.lovk,
        listOf(
            R.drawable.antimage,
            R.drawable.faceless_void,
            R.drawable.juggernaut
        )
    ),
    BookCategory(
        R.string.intel,
        listOf(
            R.drawable.zuus,
            R.drawable.storm_spirit,
            R.drawable.skywrath_mage
        )
    ),
    BookCategory(
        R.string.univer,
        listOf(
            R.drawable.enigma,
            R.drawable.snapfire,
            R.drawable.broodmother
        )
    )
)

@Composable
fun ListScreen(){
    MyList()

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyList(){
    LazyColumn{
        items(items) { item -> ListItem(item)}
    }
}

@Composable
fun ListItem(bookCategory: BookCategory, modifier: Modifier = Modifier){
    Column (modifier = Modifier.padding(8.dp)) {
        Text(
            text = stringResource(bookCategory.categoryResourcesId),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.colorPrimary)
        )
        Spacer(modifier = modifier.height(8.dp))
        LazyRow {
            items(bookCategory.bookImageResources){
                items->BookImage(items)
            }
        }
    }
}

@Composable
fun BookImage(imageResource: Int){
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = stringResource(id = R.string.menu),
        modifier = Modifier
            .size(200.dp)
            .padding(4.dp))
}

data class BookCategory(
    @StringRes
    val categoryResourcesId: Int,
    val bookImageResources: List<Int>
)