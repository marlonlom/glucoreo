package dev.marlonlom.apps.glucoreo.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.marlonlom.apps.glucoreo.ui.window_sizes.GlucoreoWindowSizes
import timber.log.Timber

/**
 * Welcome route screen composable ui parameters data class.
 *
 * @author marlonlom
 *
 * @property windowSizes Window size checking utility.
 * @property onGoogleSignInButtonClicked Action related to Google signin button clicked.
 */
data class WelcomeRouteParam(
  val windowSizes: GlucoreoWindowSizes,
  val onGoogleSignInButtonClicked: () -> Unit
)

/**
 * Welcome route screen composable ui.
 *
 * @author marlonlom
 *
 * @param routeParam Welcome route screen composable ui parameters
 */
@Composable
fun WelcomeRoute(
  routeParam: WelcomeRouteParam
) {
  when {
    routeParam.windowSizes.isMobileLandscape -> {
      Timber.d("[WelcomeRoute] displaying LandscapeWelcomeScreen for Phone")
      LandscapeWelcomeScreen(
        onGoogleSignInButtonClicked = routeParam.onGoogleSignInButtonClicked
      )
    }

    routeParam.windowSizes.isTabletLandscape -> {
      Timber.d("[WelcomeRoute] displaying LandscapeWelcomeScreen for Tablet")
      LandscapeWelcomeScreen(
        onGoogleSignInButtonClicked = routeParam.onGoogleSignInButtonClicked
      )
    }

    else -> {
      Timber.d("[WelcomeRoute] displaying PortraitWelcomeScreen")
      PortraitWelcomeScreen(routeParam.onGoogleSignInButtonClicked)
    }
  }
}

@Composable
private fun LandscapeWelcomeScreen(
  onGoogleSignInButtonClicked: () -> Unit,
  contentVerticalArrangement: Arrangement.Vertical = Arrangement.Center
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(20.dp),
    verticalArrangement = contentVerticalArrangement,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    WelcomeTitle()
    Spacer(modifier = Modifier.height(20.dp))
    Row(
      horizontalArrangement = Arrangement.spacedBy(20.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(
        modifier = Modifier.fillMaxWidth(0.5f),
      ) {
        WelcomeDescription()
      }
      Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        WelcomeImage()
        Spacer(modifier = Modifier.height(20.dp))
        GoogleSignInButton(onGoogleSignInButtonClicked)
      }
    }
  }
}

@Composable
private fun PortraitWelcomeScreen(
  onGoogleSignInButtonClicked: () -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(20.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    WelcomeTitle()
    Spacer(modifier = Modifier.padding(vertical = 20.dp))
    WelcomeImage()
    WelcomeDescription()
    Spacer(modifier = Modifier.weight(1f, true))
    GoogleSignInButton(onGoogleSignInButtonClicked)
  }
}
