/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.marlonlom.apps.glucoreo.R
import dev.marlonlom.apps.glucoreo.ui.window_sizes.GlucoreoWindowSizes


/**
 * Onboarding route composable ui parameters data class.
 *
 * @author marlonlom
 *
 * @property windowSizes window sizes utility.
 * @property userData User data from auth.
 * @property modifier Layout modifier.
 */
data class OnboardingRouteParam(
  val userData: UserAccountData,
  val windowSizes: GlucoreoWindowSizes,
  val onSaveButtonClicked: (UserProfileData?) -> Unit,
  val modifier: Modifier,
)

/**
 * Onboarding route composable ui.
 *
 * @author marlonlom
 *
 * @param routeParam Onboarding route screen composable ui parameters.
 */
@ExperimentalMaterial3Api
@Composable
fun OnboardingRoute(
  routeParam: OnboardingRouteParam
) {

  val uiState = rememberUserProfileDataUiState(
    routeParam.userData.uid
  )

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
    ProfileHeadingSection(routeParam)

    ProfileCompletionMessage()

    ProfileFormSection(R.string.text_onboarding_title_genre) {
      UserGenreChipGroup(state = uiState)
    }

    ProfileFormSection(R.string.text_onboarding_title_age_range) {
      UserAgeChipGroup(state = uiState)
    }

    ProfileFormSection(R.string.text_onboarding_title_diabetes_type) {
      UserDiabetesTypeChipGroup(state = uiState)
    }

    ProfileFormSection(R.string.text_onboarding_title_measurement_unit) {
      MeasurementUnitChipGroup(state = uiState)
    }

    Spacer(modifier = Modifier.weight(1f, true))

    Divider(modifier = Modifier.padding(top = 10.dp))

    SaveProfileButton(
      routeParam = routeParam,
      state = uiState
    )
  }
}
