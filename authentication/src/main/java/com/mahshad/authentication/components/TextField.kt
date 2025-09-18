package com.mahshad.authentication.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(
    username: String,
    updateUsername: (username: String) -> Unit,
) {
    OutlinedTextField(
        value = username,
        onValueChange = { username: String ->
            updateUsername.invoke(username)
        },
        modifier = Modifier
            .width(357.dp)
            .wrapContentHeight()
            .padding(bottom = 30.dp),
        shape = RoundedCornerShape(18.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        placeholder = { Text("example@example.com") }
    )
}