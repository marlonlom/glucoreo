/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.ui.navigation.routes

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.marlonlom.apps.glucoreo.onboarding.OnboardingRoute
import dev.marlonlom.apps.glucoreo.onboarding.OnboardingRouteParam
import dev.marlonlom.apps.glucoreo.onboarding.UserAccountData
import dev.marlonlom.apps.glucoreo.ui.navigation.Destination
import dev.marlonlom.apps.glucoreo.ui.navigation.NavigationActions
import dev.marlonlom.apps.glucoreo.ui.window_sizes.GlucoreoWindowSizes
import timber.log.Timber
import java.util.UUID

/**
 * Creates a composable route for onboarding page.
 *
 * @param modifier Composable ui content modifier reference.
 * @param windowSizes Window size checking utility.
 * @param navigationActions Navigation actions utility.
 */
@ExperimentalMaterial3Api
fun NavGraphBuilder.onboardingRoute(
  modifier: Modifier,
  windowSizes: GlucoreoWindowSizes,
  navigationActions: NavigationActions,
) {
  val onboardingRouteName = Destination.Onboarding.route
  composable(onboardingRouteName) {
    OnboardingRoute(
      routeParam = OnboardingRouteParam(
        userData = UserAccountData(
          uid = UUID.randomUUID().toString().replace("-", ""),
          displayName = "Lorem Ipsum",
          photoUrl = "https://lh3.googleusercontent.com/ogw/AGvuzYYgiJTqXGKfAU-HNqXAyJFq1zsJU6UuoeFKhEsus1E=s64-c-mo",
          email = "notengo@no.com",
        ),
        windowSizes = windowSizes,
        onSaveButtonClicked = { profileData ->
          Timber.d("[NavigationHost] onSaveButtonClicked. profileData=$profileData")
          navigationActions.toggleAuthenticated(true)
          navigationActions.gotoDashboard(onboardingRouteName)
        },
        modifier = modifier
      )
    )
  }
}
