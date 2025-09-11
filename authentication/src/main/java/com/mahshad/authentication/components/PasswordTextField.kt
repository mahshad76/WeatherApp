package com.mahshad.authentication.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mahshad.authentication.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    password: String,
    isPasswordVisible: Boolean,
    updatePassword: (password: String) -> Unit,
    updatePasswordVisibility: (isVisible: Boolean) -> Unit
) {
    OutlinedTextField(
        value = password,
        onValueChange = { updatePassword.invoke(it) },
        modifier = Modifier
            .width(357.dp)
            .wrapContentHeight()
            .padding(bottom = 60.dp),
        shape = RoundedCornerShape(18.dp),
        visualTransformation = if (isPasswordVisible)
            VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        placeholder = { Text("••••••••") },
        trailingIcon = {
            val image = if (isPasswordVisible) {
                painterResource(id = android.R.drawable.ic_menu_view)
            } else {
                painterResource(R.drawable.eye_pass)
            }

            IconButton(onClick = { updatePasswordVisibility.invoke(isPasswordVisible) }) {
                Icon(painter = image, contentDescription = "Toggle password visibility")
            }
        }
    )
}