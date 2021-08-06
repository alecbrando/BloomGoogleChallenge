package com.alecbrando.bloom.ui.theme.Components.LogInScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alecbrando.bloom.ui.theme.BloomTheme


@Composable
fun LoginScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 184.dp))
            Text(
                text = "Log in with email",
                style = MaterialTheme.typography.h1
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                label = {
                    Text(
                        text = "Email address",
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                label = {
                    Text(
                        text = "Password (8+ characters)",
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            Text(
                text = AnnotatedString(
                    text = "By clicking below you agree to our",
                ).plus(
                    AnnotatedString(
                        text = " Terms of Use ",
                        spanStyle = SpanStyle(textDecoration = TextDecoration.Underline)
                    )
                ).plus(
                    AnnotatedString(
                        text = " and consent to our ",
                    )
                ).plus(
                    AnnotatedString(
                        text = "Privacy Policy",
                        spanStyle = SpanStyle(textDecoration = TextDecoration.Underline)
                    )
                ),
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp)
            )
            Button(
                onClick = { /*TODO*/ },
                shape = MaterialTheme.shapes.medium,
                colors = buttonColors(MaterialTheme.colors.secondary),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "Log in",
                    color = MaterialTheme.colors.onSecondary
                )
            }
        }
    }
}


@Composable
@Preview
fun LoginScreenLightPreview() {
    BloomTheme(darkTheme = false) {
        LoginScreen(navController = rememberNavController())
    }
}

@Composable
@Preview
fun LoginScreenDarkPreview() {
    BloomTheme(darkTheme = true) {
        LoginScreen(navController = rememberNavController())
    }
}