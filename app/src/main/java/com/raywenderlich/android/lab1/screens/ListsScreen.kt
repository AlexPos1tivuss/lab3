package com.raywenderlich.android.lab1.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
    MyListScreen()

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyListScreen(){

}

@Composable
fun ListItem(@DrawableRes imageResId: Int, @StringRes contentDescriptionResId: Int){
    Image(
        bitmap = ImageBitmap.imageResource(imageResId),
        contentDescription = stringResource(contentDescriptionResId),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.size(476.dp, 616.dp))
}

data class BookCategory(
    @StringRes
    val categoryResourcesId: Int,
    val bookImageResources: List<Int>
)