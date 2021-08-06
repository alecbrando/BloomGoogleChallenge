package com.alecbrando.bloom.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.alecbrando.bloom.R


private val NunitoSansBold = FontFamily(Font(R.font.nunitosansbold))
private val NunitoSansLight = FontFamily(Font(R.font.nunitosanslight))
private val NunitoSansSemiBold = FontFamily(Font(R.font.nunitosanssemibold))

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = NunitoSansBold,
        fontSize = 18.sp
    ),
    h2 = TextStyle(
        fontFamily = NunitoSansBold,
        fontSize = 14.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = NunitoSansLight,
        fontSize = 16.sp,
    ),
    body1 = TextStyle(
        fontFamily = NunitoSansLight,
        fontSize = 14.sp,
    ),
    body2 = TextStyle(
        fontFamily = NunitoSansLight,
        fontSize = 12.sp,
    ),
    button = TextStyle(
        fontFamily = NunitoSansSemiBold,
        fontSize = 14.sp,
        letterSpacing = 1.sp
    ),
    caption = TextStyle(
        fontFamily = NunitoSansSemiBold,
        fontSize = 12.sp
    )
)