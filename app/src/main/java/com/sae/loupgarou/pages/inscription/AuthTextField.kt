package com.sae.loupgarou.pages.inscription

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation.Companion.None
import androidx.compose.ui.unit.dp
import com.sae.loupgarou.R

@Composable
fun AuthTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    errorMessage: String = "",
    isPassword: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = colorResource(id = R.color.light_blue),
            fontFamily = fontAldrich,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = CutCornerShape(8.dp),
            isError = isError,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else None,
            supportingText = {
                if (isError) {
                    Text(errorMessage, color = Color.Red, fontFamily = fontAldrich)
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = colorResource(id = R.color.deep_blue),
                unfocusedContainerColor = colorResource(id = R.color.deep_blue),
                errorContainerColor = colorResource(id = R.color.deep_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue),
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                cursorColor = colorResource(id = R.color.light_blue),
                focusedTextColor = colorResource(id = R.color.light_blue),
                unfocusedTextColor = colorResource(id = R.color.light_blue),
                errorTextColor = colorResource(id = R.color.light_blue)
            )
        )
    }
}