package com.raywenderlich.android.lab1.screens

import android.widget.GridView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.lab1.R
import com.raywenderlich.android.lab1.router.BackButtonHandler
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen
import kotlin.math.ceil

private val items = listOf(
    Icons.Filled.Call,
    Icons.Filled.Delete,
    Icons.Filled.Favorite,
    Icons.Filled.AccountBox,
    Icons.Filled.AccountCircle,
    Icons.Filled.Build,
    Icons.Filled.Edit,
    Icons.Filled.Face,
    Icons.Filled.Home
)

@Composable
fun GridScreen(){
    GridView(3)

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun GridView(columnCount: Int){
    val itemSize = items.size
    val rowCount = ceil(itemSize.toFloat() / columnCount).toInt()
    val gridItems = mutableListOf<List<IconResource>>()
    var position = 0
    for(i in 0  until  rowCount){
        val rowItem = mutableListOf<IconResource>()
        for (j in 0  until  columnCount){
            rowItem.add(IconResource(items[position++], true))
        }
        val itemsToFill = columnCount - rowItem.size
        for (j in 0  until itemsToFill){
            rowItem.add(IconResource(Icons.Filled.Delete, false))
        }
        gridItems.add(rowItem)
    }
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(gridItems){
            items->
            RowItem(rowItems = items)
        }
    }
}

@Composable
fun RowItem(rowItems: List<IconResource>){
    Row {
        for(element in rowItems)
            GridIcon(element)
    }
}

@Composable
fun RowScope.GridIcon(iconResource: IconResource){
    val color = if (iconResource.inVisible)
        colorResource(id = R.color.colorPrimary)
    else Color.Transparent

    Icon(
        imageVector = iconResource.imageVector,
        tint = color,
        contentDescription = stringResource(R.string.grid_button_nav),
        modifier = Modifier
            .size(80.dp, 80.dp)
            .weight(1f)
    )
}

data class IconResource(
    val imageVector: ImageVector,
    val inVisible: Boolean
)