package com.sachin.jobapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Red200 = Color(0xFFDB7169)
val Purple500 = Color(0xFF6200EE)
val Red500 = Color(0xFFD61A0C)
val Purple700 = Color(0xFF3700B3)
val Red700 = Color(0xFFE44C41)
val Teal200 = Color(0xFF03DAC5)
val DarkVintage200 = Color(0xFF400E32)
val pink = Color(0xFFFF0032)
val darkBlue = Color(0xFF00005C)

val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)
val StarColor = Color(0xFFFFC94D)

val ShimmerLightGray = Color(0xFFF1F1F1)
val ShimmerMediumGray = Color(0xFFE3E3E3)
val ShimmerDarkGray = Color(0xFF1D1D1D)

val Colors.statusBarColor
    get() = if (isLight) Red700 else Color.Black

val Colors.welcomeScreenBackgroundColor
    get() = if (isLight) Color.White else Color.Black

val Colors.titleColor
    get() = if (isLight) DarkGray else LightGray

val Colors.descriptionColor
    get() = if (isLight) DarkGray.copy(alpha = 0.5f)
    else LightGray.copy(alpha = 0.5f)

val Colors.activeIndicatorColor
    get() = if (isLight) Red500 else Red700

val Colors.inactiveIndicatorColor
    get() = if (isLight) LightGray else DarkGray

val Colors.buttonBackgroundColor
    get() = if (isLight) Red500 else Red700

val Colors.topAppBarContentColor: Color
    get() = if (isLight) Color.White else LightGray

val Colors.topAppBarBackgroundColor: Color
    get() = if (isLight) Red500 else Color.Black