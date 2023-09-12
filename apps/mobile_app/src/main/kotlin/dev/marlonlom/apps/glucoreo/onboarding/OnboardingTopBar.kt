/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import dev.marlonlom.apps.glucoreo.R

@ExperimentalMaterial3Api
@Composable
fun OnboardingTopBar(
) {
  CenterAlignedTopAppBar(
    modifier = Modifier
      .fillMaxWidth()
      .background(MaterialTheme.colorScheme.surface),
    title = {
      Text(stringResource(R.string.text_onboarding_title_top_bar))
    },
  )
}
