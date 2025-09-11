package com.mahshad.authentication.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WhiteBackground(form: @Composable () -> Unit) {
    Surface(
        modifier = Modifier
            .width(430.dp)
            .fillMaxHeight()
            .padding(top = 150.dp),
        color =  Color(0xFFF1FFF3),
        shape = RoundedCornerShape(
            topStart = 40.dp,
            topEnd = 40.dp,
            bottomStart = 40.dp,
            bottomEnd = 40.dp
        ),
    ) {
        form()
    }
}
