package com.mahshad.authentication.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WhiteBackground(form: () -> Unit) {
    Surface(
        modifier = Modifier
            .width(430.dp)
            .height(745.dp)
            .padding(top = 150.dp),
        color = Color.White,
        shape = RoundedCornerShape(
            topStart = 40.dp,
            topEnd = 40.dp,
            bottomStart = 40.dp,
            bottomEnd = 40.dp
        )
    ) {
        form()
    }
}
