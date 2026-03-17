package com.sae.loupgarou.pages.historique

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
    Column() {

            Text(text = date.toString(),
                color = colorResource(R.color.white)
            )


            Text(text = gameResult,
                color = colorResource(R.color.white)
            )


                Text(text = "${stringResource(string.pendant) } $nightsCount  ${stringResource(string.nuit)}",
                    color = colorResource(R.color.white)
                )
            }

}
