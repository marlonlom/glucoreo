/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.marlonlom.apps.glucoreo.onboarding.UserAccountData
import dev.marlonlom.apps.glucoreo.ui.navigation.NavigationActions
import dev.marlonlom.apps.glucoreo.ui.window_sizes.GlucoreoWindowSizes

/**
 * Home route screen composable ui parameters data class.
 *
 * @author marlonlom
 *
 * @property windowSizes Window size checking utility.
 */
data class HomeRouteParam(
  val userData: UserAccountData,
  val windowSizes: GlucoreoWindowSizes,
  val navigationActions: NavigationActions,
  val modifier: Modifier = Modifier,
)

/**
 * Home route screen composable ui.
 *
 * @author marlonlom
 *
 * @param routeParam Home route screen composable ui parameters.
 */
@Composable
fun HomeRoute(routeParam: HomeRouteParam) {

  val contentPadding = when {
    routeParam.windowSizes.isMobileLandscape -> PaddingValues(horizontal = 160.dp, vertical = 20.dp)
    routeParam.windowSizes.isTabletLandscape -> PaddingValues(horizontal = 200.dp, vertical = 20.dp)
    routeParam.windowSizes.isTabletWidth -> PaddingValues(horizontal = 80.dp, vertical = 20.dp)
    else -> PaddingValues(20.dp)
  }

  Column(
    modifier = routeParam.modifier
      .fillMaxSize()
      .padding(contentPadding)
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.SpaceBetween,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    HomeProfileBanner(routeParam)
    GlucoseLectureChart(routeParam)
    Spacer(modifier = Modifier.weight(1f, true))
  }
}
