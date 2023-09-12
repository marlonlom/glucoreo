/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.ui.navigation.routes

import android.app.Activity
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.marlonlom.apps.glucoreo.ui.navigation.Destination
import dev.marlonlom.apps.glucoreo.ui.navigation.NavigationActions
import dev.marlonlom.apps.glucoreo.ui.signin.doSignIn
import dev.marlonlom.apps.glucoreo.ui.signin.obtainOneTapSigninLauncher
import dev.marlonlom.apps.glucoreo.ui.window_sizes.GlucoreoWindowSizes
import dev.marlonlom.apps.glucoreo.welcome.WelcomeRoute
import dev.marlonlom.apps.glucoreo.welcome.WelcomeRouteParam
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Creates a composable route for welcome page.
 *
 * @author marlonlom
 *
 * @param windowSizes Window size checking utility.
 * @param navigationActions Navigation actions utility.
 */
fun NavGraphBuilder.welcomeRoute(
  windowSizes: GlucoreoWindowSizes,
  navigationActions: NavigationActions
) {
  val welcomeRouteName = Destination.Welcome.route
  composable(welcomeRouteName) {
    val coroutineScope = rememberCoroutineScope()
    val activity = LocalContext.current as Activity
    val launcher = obtainOneTapSigninLauncher(
      activity = activity,
      onSignInSuccess = {
        Timber.d("[NavGraph.welcomeRoute] userData=$it ")
        navigationActions.gotoOnboarding(
          currentRoute = welcomeRouteName
        )
      },
      onSignInFailed = {
        Timber.e("[NavGraph.welcomeRoute] onSignInFailed.")
      }
    )
    WelcomeRoute(
      routeParam = WelcomeRouteParam(
        windowSizes = windowSizes,
        onGoogleSignInButtonClicked = {
          coroutineScope.launch {
            doSignIn(
              context = activity,
              launcher = launcher
            )
          }
        },
      )
    )
  }
}

