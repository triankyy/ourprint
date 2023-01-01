package com.example.ourprint.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ourprint.layout.AuthLayout

@Preview(showBackground = true)
@Composable
private fun RegisterPreview() {
    RegisterPage(null)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(navController: NavHostController?) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    val email = remember { mutableStateOf(TextFieldValue()) }

    AuthLayout {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(40.dp, 0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("OurPrint",
                style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.W900, color = Color.White)
            )
            Text("Selamat Datang", style = TextStyle(color = Color.White))
            Spacer(Modifier.height(20.dp))
            OutlinedTextField(
                placeholder = { Text("Email") },
                value = email.value,
                onValueChange = { email.value = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
        }
    }
}