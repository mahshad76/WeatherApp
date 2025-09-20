package com.mahshad.systemdesign

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MatchPatternNote(text: String) {
    Text(
        text,
        modifier = Modifier
            .width(357.dp)
            .wrapContentHeight()
            .padding(bottom = 30.dp, start = 17.dp, end = 17.dp),
        color = Color.Gray.copy(alpha = 0.8f),
        textAlign = TextAlign.Justify
    )
}