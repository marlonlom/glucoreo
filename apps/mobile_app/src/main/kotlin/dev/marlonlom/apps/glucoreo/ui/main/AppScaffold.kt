package dev.marlonlom.apps.glucoreo.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.marlonlom.apps.glucoreo.home.HomeTopBar
import dev.marlonlom.apps.glucoreo.onboarding.OnboardingTopBar
import dev.marlonlom.apps.glucoreo.ui.navigation.Destination
import dev.marlonlom.apps.glucoreo.ui.navigation.NavigationActions
import dev.marlonlom.apps.glucoreo.ui.navigation.NavigationHost
import dev.marlonlom.apps.glucoreo.ui.window_sizes.GlucoreoWindowSizes

/**
 * Main scaffold composable ui.
 *
 * @author marlonlom
 *
 * @param windowSizes Window size checking utility.
 * @param navigationActions Navigation actions utility.
 */
@ExperimentalMaterial3Api
@Composable
fun AppScaffold(
  windowSizes: GlucoreoWindowSizes,
  navigationActions: NavigationActions,
  currentRoute: String,
) {
  val floatingActionButtonPosition: (Boolean) -> FabPosition = { positionedToEnd ->
    if (positionedToEnd) FabPosition.End else FabPosition.Center
  }

  Scaffold(
    modifier = Modifier
      .fillMaxWidth()
      .background(MaterialTheme.colorScheme.surface),
    topBar = {
      if (currentRoute == Destination.Home.route) {
        HomeTopBar(
          currentRoute = currentRoute,
          navigationActions = navigationActions,
        )
      } else if (currentRoute == Destination.Onboarding.route) {
        OnboardingTopBar()
      }
    },
    floatingActionButtonPosition = floatingActionButtonPosition(windowSizes.isMobileLandscape),
    floatingActionButton = {
      if (currentRoute == Destination.Home.route) {
        CreateGlucoseLectureFab(
          currentRoute = currentRoute,
          navigationActions = navigationActions,
        )
      }
    },
    content = { paddingValues ->
      val contentModifier = Modifier
        .fillMaxWidth()
        .padding(paddingValues)

      NavigationHost(
        modifier = contentModifier,
        windowSizes = windowSizes,
        navigationActions = navigationActions,
      )
    },
  )
}
