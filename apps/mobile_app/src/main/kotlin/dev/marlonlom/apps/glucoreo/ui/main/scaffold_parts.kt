/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.ui.main

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.marlonlom.apps.glucoreo.R
import dev.marlonlom.apps.glucoreo.ui.navigation.NavigationActions

/**
 * Glucose lecture creation floating action button composable ui.
 *
 * @author marlonlom
 *
 * @param navigationActions
 */
@Composable
fun CreateGlucoseLectureFab(
  navigationActions: NavigationActions,
  currentRoute: String
) {
  FloatingActionButton(
    onClick = {
      navigationActions.gotoCreateLecture(currentRoute)
    },
    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
    contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
    shape = RoundedCornerShape(10.dp),
  ) {
    Icon(
      imageVector = Icons.Rounded.Add,
      contentDescription = stringResource(
        R.string.text_home_fab_create_lecture
      )
    )
  }
}
