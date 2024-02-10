package com.raywenderlich.android.lab1.screens

import android.widget.GridView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
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


@Composable
fun GridScreen(){
    GridView(3)

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun GridView(columnCount: Int){
    val itemSize = item.size
    val rowCount = ceil(itemSize.toFloat() / columnCount).toInt()
    var position = 0
    for(i in 0<=until<rowCount){
        val rowItem = mutableListOf<IconResource>()
        for (j in 0 <= until < columnCount){
            rowItem.add(IconResource(items[position++], true))
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
    val color = if (iconResource.isVisible)
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