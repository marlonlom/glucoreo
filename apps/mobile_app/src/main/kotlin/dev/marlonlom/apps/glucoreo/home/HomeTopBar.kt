/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.marlonlom.apps.glucoreo.ui.navigation.NavigationActions

@ExperimentalMaterial3Api
@Composable
fun HomeTopBar(
  currentRoute: String,
  navigationActions: NavigationActions,
) {
  CenterAlignedTopAppBar(
    modifier = Modifier
      .fillMaxWidth()
      .background(MaterialTheme.colorScheme.surface),
    title = { },
    actions = {
      IconButton(
        onClick = { navigationActions.gotoSettings(currentRoute) },
      ) {
        Icon(
          imageVector = Icons.Rounded.Settings, contentDescription = "Settings icon button"
        )
      }
    },
  )
}
