package com.sae.loupgarou.pages.rules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.string
import com.sae.loupgarou.pages.Retour
import com.sae.loupgarou.fontAldrich



@Composable
fun RulePage(onReturn: () -> Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = color.marine))
        .padding(20.dp, 50.dp)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Rules()
        Roles()
        Deroulement()
        Text(text = stringResource(string.chose_right),
            color = colorResource(id = color.light_blue),
            fontFamily = fontAldrich
        )
        Retour(onReturn)
    }
}

