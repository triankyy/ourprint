package com.example.ourprint.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ourprint.R

@Preview(showBackground = true)
@Composable
private fun AuthLayoutPreview() = AuthLayout {}


@Composable
fun AuthLayout(content: @Composable BoxScope.() -> Unit) {
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
        content()
    }
}