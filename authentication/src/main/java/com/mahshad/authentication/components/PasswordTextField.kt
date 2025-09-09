package com.mahshad.authentication.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(password: String, updatePassword: () -> Unit) {
    OutlinedTextField(
        value = password,
        onValueChange = { updatePassword.invoke() },
        modifier = Modifier
            .width(357.dp)
            .wrapContentHeight(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color(0xFFDFF7E2)
        ),
        shape = RoundedCornerShape(18.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        placeholder = { Text("••••••••") },
        trailingIcon = {
            val image = if (passwordVisible) {
                painterResource(id = android.R.drawable.ic_menu_view)
            } else {
                painterResource(id = android.R.drawable.ic_menu_close_clear_cancel)
            }

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(painter = image, contentDescription = "Toggle password visibility")
            }
        }
    )
}