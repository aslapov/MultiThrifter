package com.multithrifter.ui

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

@Composable
fun MultiThrifterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val isLight = !darkTheme
    MaterialTheme(
        content = {
            CompositionLocalProvider(
                LocalIndication provides rememberRipple(),
                LocalContentColor provides MultiThrifterColors.Primary,
                LocalContentAlpha provides 1f,
                content = content,
            )
        },
        typography = multiThrifterTypography,
        colors = Colors(
            primary = MultiThrifterColors.Primary,
            primaryVariant = MultiThrifterColors.Primary,
            secondary = MultiThrifterColors.background,
            secondaryVariant = MultiThrifterColors.secondary,
            background = MultiThrifterColors.background,
            surface = MultiThrifterColors.background,
            error = MultiThrifterColors.backgroundError,
            onPrimary = Color.White,
            onSecondary = Color.Black,
            onBackground = Color.Black,
            onSurface = MultiThrifterColors.middleGray,
            onError = Color.White,
            isLight = isLight,
        )
    )
}