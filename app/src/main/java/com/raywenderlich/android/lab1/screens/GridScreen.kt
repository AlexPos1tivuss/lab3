package com.raywenderlich.android.lab1.screens

import android.widget.GridView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.lab1.router.BackButtonHandler
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen



@Composable
fun GridScreen(){
    GridView(3)

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun GridView(columnCount: Int){

}

@Composable
fun RowItem(rowItems: List<IconResource>){

}

@Composable
fun RowScope.GridIcon(iconResource: IconResource){

}

data class IconResource(
    val imageVector: ImageVactor,
    val inVisible: Boolean
)