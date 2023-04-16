package com.multithrifter.ui

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

private val Regular = FontWeight.W400

private val robotoFontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.roboto_medium,
            weight = FontWeight.Medium
        ),
        Font(
            resId = R.font.roboto_regular,
            weight = Regular
        )
    )
)

internal val multiThrifterTypography = Typography(
    h1 = TextStyle(
        fontFamily = robotoFontFamily,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(LineHeightStyle.Alignment.Center, LineHeightStyle.Trim.None)
    ),
    h2 = TextStyle(
        fontFamily = robotoFontFamily,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.38.sp,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(LineHeightStyle.Alignment.Center, LineHeightStyle.Trim.None)
    ),
    h3 = TextStyle(
        fontFamily = robotoFontFamily,
        fontSize = 19.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.2.sp,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(LineHeightStyle.Alignment.Center, LineHeightStyle.Trim.None)
    ),
    body1 = TextStyle(
        fontFamily = robotoFontFamily,
        fontSize = 17.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
        fontWeight = Regular,
        lineHeightStyle = LineHeightStyle(LineHeightStyle.Alignment.Center, LineHeightStyle.Trim.None)
    ),
    body2 = TextStyle(
        fontFamily = robotoFontFamily,
        fontSize = 15.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.2.sp,
        fontWeight = Regular,
        lineHeightStyle = LineHeightStyle(LineHeightStyle.Alignment.Center, LineHeightStyle.Trim.None)
    ),
    caption = TextStyle(
        fontFamily = robotoFontFamily,
        fontSize = 11.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.26.sp,
        fontWeight = Regular,
        lineHeightStyle = LineHeightStyle(LineHeightStyle.Alignment.Center, LineHeightStyle.Trim.None)
    ),
)