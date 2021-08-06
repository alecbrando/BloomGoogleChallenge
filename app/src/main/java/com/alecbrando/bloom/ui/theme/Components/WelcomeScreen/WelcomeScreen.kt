package com.alecbrando.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alecbrando.bloom.ui.theme.BloomTheme

@Composable
fun WelcomeScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxSize()
    ) {
        WelcomeBackground()
        WelcomeScreenContent(navController)
    }
}

@Composable
private fun WelcomeScreenContent(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.padding(vertical = 72.dp))
        LeafyImage()
        Spacer(modifier = Modifier.padding(vertical = 48.dp))
        LogoImage()
        AppSubtitle()
        Spacer(modifier = Modifier.padding(vertical = 40.dp))
        CreateAccountButton()
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        LoginButton(navController)
    }
}

@Composable
private fun LeafyImage() {
    val isLight = MaterialTheme.colors.isLight
    val leafImageRes = if (isLight) {
        R.drawable.ic_light_welcome_illos
    } else {
        R.drawable.ic_dark_welcome_illos
    }
    Image(
        painter =
        painterResource(
            id = leafImageRes
        ),
        contentDescription = null,
        modifier = Modifier.offset(x = 88.dp)
    )
}

@Composable
private fun LogoImage() {
    val isLight = MaterialTheme.colors.isLight

    val logoImageRes = if (isLight) {
        R.drawable.ic_light_logo
    } else {
        R.drawable.ic_dark_logo
    }
    Image(
        painter = painterResource(id = logoImageRes),
        contentDescription = "Bloom"
    )
}

@Composable
private fun AppSubtitle() {
    Text(
        text = "Beautiful home garden solutions",
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.paddingFromBaseline(top = 32.dp),
        color = MaterialTheme.colors.onPrimary
    )
}

@Composable
private fun CreateAccountButton() {
    Button(
        colors = buttonColors(
            backgroundColor = MaterialTheme.colors.secondary
        ),
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxWidth()
            .height(48.dp)
    ) {
        Text(
            text = "Create account"
        )
    }
}

@Composable
private fun LoginButton(navController: NavController) {
    TextButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = MaterialTheme.shapes.medium,
        onClick = {
            navController.navigate("login_route")
        }) {
        Text(
            color = MaterialTheme.colors.secondary,
            text = "Log in"
        )
    }
}

@Composable
private fun WelcomeBackground() {
    val isLight = MaterialTheme.colors.isLight
    val backgroundImageRes = if (isLight) {
        R.drawable.ic_light_welcome_bg
    } else {
        R.drawable.ic_dark_welcome_bg
    }
    Image(
        painterResource(id = backgroundImageRes),
        contentDescription = "",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
}

@Preview
@Composable
private fun PreviewDarkWelcomeScreen() {
    BloomTheme(darkTheme = true) {
        WelcomeScreen(navController = rememberNavController())
    }

}

@Preview
@Composable
private fun PreviewLightWelcomeScreen() {
    BloomTheme(darkTheme = false) {
        WelcomeScreen(navController = rememberNavController())
    }
}