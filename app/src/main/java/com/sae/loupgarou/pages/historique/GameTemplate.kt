package com.sae.loupgarou.pages.historique

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sae.loupgarou.R
import java.util.Date
import com.sae.loupgarou.R.string

@Composable
fun GameTemplate(date : Date,
                 gameResult : String,
                 nightsCount : Int
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        item {
            Text(text = date.toString())
        }
        item {
            Text(text = gameResult)
        }
        item {
            if(nightsCount > 1){
                Text(text = " ${stringResource(string.pendant)}  $nightsCount  ${stringResource(string.nuit)}");
            }else{
                Text(text = " ${stringResource(string.pendant)}  $nightsCount  ${stringResource(string.nuits)}");
            }
        }

    }
}
