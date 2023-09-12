/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.marlonlom.apps.glucoreo.ui.main.AppScaffold
import dev.marlonlom.apps.glucoreo.ui.navigation.Destination
import dev.marlonlom.apps.glucoreo.ui.navigation.NavigationActions
import dev.marlonlom.apps.glucoreo.ui.theme.GlucoreoTheme
import dev.marlonlom.apps.glucoreo.ui.window_sizes.GlucoreoWindowSizes

/**
 * Main activity for application.
 *
 * @author marlonlom
 *
 */
@ExperimentalMaterial3Api
@ExperimentalMaterial3WindowSizeClassApi
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MainContent()
    }
  }

  @Composable
  private fun MainContent() {
    val windowSizes = GlucoreoWindowSizes(calculateWindowSizeClass(this))
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: Destination.Welcome.route

    val navigationActions = NavigationActions(
      navController = navController,
      /* TODO: check authenticated user logic from some ui state */
      isAuthenticated = false,
    )

    GlucoreoTheme {
      AppScaffold(
        windowSizes = windowSizes,
        currentRoute = currentRoute,
        navigationActions = navigationActions,
      )
    }
  }
}
