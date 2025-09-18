package com.mahshad.authentication.design

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Button(
    onClick: () -> Unit,
    name: String,
    buttonColor: Color,
    contentColor: Color,
    enabled: Boolean = false
) {
    Button(
        onClick,
        modifier = Modifier
            .width(207.dp)
            .wrapContentHeight()
            .padding(bottom = 30.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = contentColor
        ),
        enabled = enabled
    ) {
        Text(name)
    }
}