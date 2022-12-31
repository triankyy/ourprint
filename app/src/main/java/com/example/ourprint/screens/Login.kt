package com.example.ourprint.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ourprint.ui.theme.OurPrintTheme
import com.example.ourprint.R
import com.example.ourprint.ui.theme.Purple

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    OurPrintTheme {
//        LoginPage()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current

    val email = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(R.drawable.login_vector_atas),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.TopStart
        )
        Image(
            painterResource(R.drawable.login_vector_1),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.TopEnd
        )
        Box(Modifier.fillMaxSize(), Alignment.BottomStart) {
            Image(
                painterResource(R.drawable.login_vector_bawah),
                contentDescription = ""
            )
        }
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
                Text("Belum Punya Akun?")
                ClickableText(
                    text = AnnotatedString("Daftar Disini"),
                    style = TextStyle(
                        color = Purple,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        letterSpacing = 0.5.sp
                    ),
                    onClick = { navController.navigate("Register") }
                )
            }
        }
    }
}