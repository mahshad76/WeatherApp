package com.mahshad.authentication.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BlueBackground() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00B1D0)),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Text(
            modifier = Modifier
                .padding(top = 67.dp),
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp,
            text = "Welcome"
        )
    }

}

@Preview
@Composable
fun Preview() {
    BlueBackground()
}