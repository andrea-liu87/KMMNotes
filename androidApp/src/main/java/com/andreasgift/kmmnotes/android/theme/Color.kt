package com.andreasgift.kmmnotes.android.theme

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val PrimaryMain = Color(0xFFDA3630)
val SecondaryMain = Color(0xFFF8CA45)
val RedDark = Color(0xFFAE2B27)
val RedDarkButton = Color(0xFFDA3630)

val PrimaryMainBlue = Color(0xFF2196F3)
val SecondaryMainBlue = Color(0xFFF8CA45)
val BlueDark = Color(0xFF176FB4)
val BlackBlueButtonDark = Color(0xFFDA3630)

val GrayDivider = Color(0x61FFFFFF)
val SurfaceSystem = Color(0xFF646464)

//Blue
@SuppressLint("ConflictingOnColor")
val lightColors = lightColors(
    primary = PrimaryMainBlue,
    primaryVariant = BlueDark,
    onPrimary = Color.White,
    secondary = Color.White,
    onSecondary = Color.Black,
    background = PrimaryMainBlue,
    onBackground = PrimaryMainBlue,
    surface = SurfaceSystem,
    onSurface = Color.Black,
    error = BlueDark,
    onError = Color.White
)

val darkColors = darkColors(
    primary = PrimaryMain,
    primaryVariant = RedDark,
    onPrimary = Color.Blue,
    secondary = Color.Black,
    onSecondary = Color.Yellow,
    background = Color.DarkGray,
    onBackground = Color.Green,
    surface = Color.Magenta,
    onSurface = Color.White,
    error = RedDark,
    onError = Color.Blue
)