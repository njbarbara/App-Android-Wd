package com.sae.loupgarou.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.string

val fontAldrich = FontFamily(
    Font(R.font.aldrich_regular, FontWeight.Normal)
)

@Composable
fun Retour(onReturn: () -> Unit){
    OutlinedButton(
        onClick = { onReturn() },
        shape = CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = color.deep_blue), shape=CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp)),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 2.dp,
            brush = androidx.compose.ui.graphics.SolidColor(colorResource(id = color.light_blue))
        )
    ) {
        Text(stringResource(string.return_button),
            fontFamily = fontAldrich,
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 20.sp)
    }
}
