/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.ui.navigation

import androidx.navigation.NavHostController
import timber.log.Timber


/**
 * App destination sealed class.
 *
 * @author marlonlom
 *
 * @property route Route name.
 */
sealed class Destination(
  val route: String
) {
  object Welcome : Destination(route = "welcome")
  object Onboarding : Destination(route = "onboarding")
  object Home : Destination(route = "home")
  object Settings : Destination(route = "settings")
}


class NavigationActions(
  private var isAuthenticated: Boolean,
  val navController: NavHostController,
) {

  val defaultDestination get() = if (isAuthenticated) Destination.Home.route else Destination.Welcome.route

  fun toggleAuthenticated(newValue: Boolean) {
    isAuthenticated = newValue
  }

  fun gotoOnboarding(currentRoute: String) {
    if (currentRoute != Destination.Welcome.route) {
      return
    }
    navController.navigate(Destination.Onboarding.route)
  }

  fun gotoDashboard(currentRoute: String) {
    if (currentRoute != Destination.Onboarding.route) {
      return
    }
    navController.popBackStack(navController.graph.startDestinationId, true)
    navController.navigate(Destination.Home.route)
  }

  fun gotoSettings(currentRoute: String) {
    if (currentRoute != Destination.Home.route) {
      return
    }
    navController.navigate(Destination.Settings.route)
  }

  fun gotoCreateLecture(currentRoute: String) {
    if (currentRoute != Destination.Home.route) {
      return
    }
    Timber.d("[gotoCreateLecture] currentRoute=$currentRoute")
  }

}

