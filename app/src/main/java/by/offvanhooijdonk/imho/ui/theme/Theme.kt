package by.offvanhooijdonk.imho.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = Teal400,
    primaryVariant = Teal400Dark,
    secondary = LightBlueA200,
    secondaryVariant = LightBlueA200Dark,
    onSecondary = Color.White,
)

private val DarkColorPalette = darkColors(
    primary = Teal400,
    primaryVariant = Teal400Dark,
    secondary = LightBlueA200,
    secondaryVariant = LightBlueA200Dark,
    onSecondary = Color.White,
)

@Composable
fun IMHOTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        appDarkPalette()
    } else {
        appLightPalette()
    }

    CompositionLocalProvider(LocalThemePalette provides colors) {
        MaterialTheme(
            colors = colors.materialColors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object AppTheme {
    val colors: ThemePalette
        @Composable get() = LocalThemePalette.current
}

interface ThemePalette {
    val materialColors: Colors
    val positive: Color
    val negative: Color
}

private fun appLightPalette(): ThemePalette = object : ThemePalette {
    override val materialColors: Colors = LightColorPalette
    override val positive: Color = GreenA700
    override val negative: Color = RedA400
}

private fun appDarkPalette() = object : ThemePalette {
    override val materialColors: Colors = DarkColorPalette
    override val positive: Color = GreenA700
    override val negative: Color = RedA400
}

private val LocalThemePalette = compositionLocalOf { appLightPalette() }