package com.example.ourprint.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.ourprint.R
import com.example.ourprint.layout.AuthLayout
import com.example.ourprint.ui.theme.*

@Preview(showBackground = true)
@Composable
private fun LoginPreview() = LoginPage(null)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController?) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    val email = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }

    AuthLayout {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .padding(40.dp, 0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("OurPrint",
                style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.W900, color = Color.White)
            )
            Text("Selamat Datang", style = TextStyle(color = Color.White))
            Spacer(Modifier.height(20.dp))
            Image(painterResource(R.drawable.login), "")
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
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                placeholder = { Text("Password") },
                value = password.value,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password.value = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                singleLine = true
            )
            Spacer(Modifier.height(30.dp))
            ElevatedButton(
                onClick = { Log.d("Login", "LoginPage: ") },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Purple),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("MASUK")
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row {
                Text("Belum Punya Akun?", fontSize = 13.sp)
                ClickableText(
                    text = AnnotatedString("Daftar Disini"),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 13.sp,
                        color = Purple
                    ),
                    onClick = { navController!!.navigate("Register") }
                )
            }
        }
    }
}