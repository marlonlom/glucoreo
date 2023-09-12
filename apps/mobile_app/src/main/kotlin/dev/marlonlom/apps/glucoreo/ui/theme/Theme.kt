/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * Branded color schemes single object.
 *
 * @author marlonlom
 */
object GlucoreoColorSchemes {

  /** Dark color scheme reference. */
  val dark = darkColorScheme(
    primary = GlucoreoColors.wildWillow,
    onPrimary = GlucoreoColors.britishRacingGreen,
    primaryContainer = GlucoreoColors.olive,
    onPrimaryContainer = GlucoreoColors.mindaro,
    secondary = GlucoreoColors.paleLeaf,
    onSecondary = GlucoreoColors.turtleGreen,
    secondaryContainer = GlucoreoColors.waiouru,
    onSecondaryContainer = GlucoreoColors.frost,
    tertiary = GlucoreoColors.sinbad,
    onTertiary = GlucoreoColors.darkGreen2,
    tertiaryContainer = GlucoreoColors.sherwoodGreen,
    onTertiaryContainer = GlucoreoColors.waterLeaf,
    error = GlucoreoColors.melon,
    errorContainer = GlucoreoColors.sangria,
    onError = GlucoreoColors.maroon2,
    onErrorContainer = GlucoreoColors.mistyRose,
    background = GlucoreoColors.maire,
    onBackground = GlucoreoColors.blackWhite,
    surface = GlucoreoColors.maire,
    onSurface = GlucoreoColors.blackWhite,
    surfaceVariant = GlucoreoColors.heavyMetal,
    onSurfaceVariant = GlucoreoColors.chromeWhite,
    outline = GlucoreoColors.lemonGrass,
    inverseOnSurface = GlucoreoColors.maire,
    inverseSurface = GlucoreoColors.blackWhite,
    inversePrimary = GlucoreoColors.olive2,
    surfaceTint = GlucoreoColors.wildWillow,
    outlineVariant = GlucoreoColors.heavyMetal,
    scrim = GlucoreoColors.black,
  )

  /** Dark color scheme reference. */
  val light = lightColorScheme(
    primary = GlucoreoColors.olive2,
    onPrimary = GlucoreoColors.white,
    primaryContainer = GlucoreoColors.mindaro,
    onPrimaryContainer = GlucoreoColors.darkGreen3,
    secondary = GlucoreoColors.woodland,
    onSecondary = GlucoreoColors.white,
    secondaryContainer = GlucoreoColors.frost,
    onSecondaryContainer = GlucoreoColors.verdunGreen,
    tertiary = GlucoreoColors.spectra,
    onTertiary = GlucoreoColors.white,
    tertiaryContainer = GlucoreoColors.waterLeaf,
    onTertiaryContainer = GlucoreoColors.darkGreen,
    error = GlucoreoColors.fireBrick,
    errorContainer = GlucoreoColors.mistyRose,
    onError = GlucoreoColors.white,
    onErrorContainer = GlucoreoColors.maroon,
    background = GlucoreoColors.floralWhite,
    onBackground = GlucoreoColors.maire,
    surface = GlucoreoColors.floralWhite,
    onSurface = GlucoreoColors.maire,
    surfaceVariant = GlucoreoColors.greenWhite,
    onSurfaceVariant = GlucoreoColors.heavyMetal,
    outline = GlucoreoColors.tapa,
    inverseOnSurface = GlucoreoColors.alabaster,
    inverseSurface = GlucoreoColors.eternity,
    inversePrimary = GlucoreoColors.wildWillow,
    surfaceTint = GlucoreoColors.olive2,
    outlineVariant = GlucoreoColors.chromeWhite,
    scrim = GlucoreoColors.black
  )
}

/**
 * Glucoreo theme composable.
 *
 * @author marlonlom
 *
 * @param darkTheme true/false if application is in dark theme.
 * @param dynamicColor true/false if application is using dynamic colors (default: true).
 * @param content Composable content that applies the theme.
 */
@ExperimentalMaterial3Api
@Composable
fun GlucoreoTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = true,
  content: @Composable () -> Unit
) {
  val glucoreoColorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }

    darkTheme -> GlucoreoColorSchemes.dark
    else -> GlucoreoColorSchemes.light
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = glucoreoColorScheme.surface.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    }
  }

  MaterialTheme(
    colorScheme = glucoreoColorScheme,
    typography = GlucoreoFont.appTypography,
    content = content
  )
}
