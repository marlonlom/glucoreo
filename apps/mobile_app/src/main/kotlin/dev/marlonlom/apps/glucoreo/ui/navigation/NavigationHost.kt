package dev.marlonlom.apps.glucoreo.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import dev.marlonlom.apps.glucoreo.ui.navigation.routes.homeRoute
import dev.marlonlom.apps.glucoreo.ui.navigation.routes.onboardingRoute
import dev.marlonlom.apps.glucoreo.ui.navigation.routes.welcomeRoute
import dev.marlonlom.apps.glucoreo.ui.window_sizes.GlucoreoWindowSizes
import timber.log.Timber

/**
 * Navigation host composable ui.
 *
 * @author marlonlom
 *
 * @param modifier Composable ui content modifier reference.
 * @param windowSizes Window size checking utility.
 * @param navigationActions Navigation actions utility.
 */
@ExperimentalMaterial3Api
@Composable
fun NavigationHost(
  modifier: Modifier = Modifier,
  windowSizes: GlucoreoWindowSizes,
  navigationActions: NavigationActions
) {

  Timber.d("[NavigationHost] defaultDestination=${navigationActions.defaultDestination}")
  NavHost(
    navController = navigationActions.navController,
    startDestination = navigationActions.defaultDestination
  ) {

    welcomeRoute(
      windowSizes = windowSizes,
      navigationActions = navigationActions
    )

    onboardingRoute(
      modifier = modifier,
      windowSizes = windowSizes,
      navigationActions = navigationActions
    )

    homeRoute(
      modifier = modifier,
      windowSizes = windowSizes,
      navigationActions = navigationActions
    )
  }
}

