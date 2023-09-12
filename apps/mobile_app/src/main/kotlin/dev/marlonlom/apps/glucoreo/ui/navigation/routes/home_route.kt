/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.ui.navigation.routes

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.marlonlom.apps.glucoreo.home.HomeRoute
import dev.marlonlom.apps.glucoreo.home.HomeRouteParam
import dev.marlonlom.apps.glucoreo.onboarding.UserAccountData
import dev.marlonlom.apps.glucoreo.ui.navigation.Destination
import dev.marlonlom.apps.glucoreo.ui.navigation.NavigationActions
import dev.marlonlom.apps.glucoreo.ui.window_sizes.GlucoreoWindowSizes
import java.util.UUID

/**
 * Creates a composable route for home page.
 *
 * @author marlonlom
 *
 * @param modifier Composable ui content modifier reference.
 * @param windowSizes Window size checking utility.
 * @param navigationActions Navigation actions utility.
 */
fun NavGraphBuilder.homeRoute(
  modifier: Modifier,
  windowSizes: GlucoreoWindowSizes,
  navigationActions: NavigationActions,
) {
  composable(Destination.Home.route) {
    HomeRoute(
      routeParam = HomeRouteParam(
        userData = UserAccountData(
          uid = UUID.randomUUID().toString().replace("-", ""),
          displayName = "Lorem Ipsum",
          photoUrl = "https://lh3.googleusercontent.com/ogw/AGvuzYYgiJTqXGKfAU-HNqXAyJFq1zsJU6UuoeFKhEsus1E=s64-c-mo",
          email = "notengo@no.com",
        ),
        windowSizes = windowSizes,
        navigationActions = navigationActions,
        modifier = modifier,
      )
    )
  }
}
