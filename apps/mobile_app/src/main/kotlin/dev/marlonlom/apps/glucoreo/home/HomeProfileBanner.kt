/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.marlonlom.apps.glucoreo.R


/**
 * Home profile banner composable ui.
 *
 * @author marlonlom
 *
 * @param routeParam Home route screen composable ui parameters.
 */
@Composable
fun HomeProfileBanner(
  routeParam: HomeRouteParam
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(bottom = 20.dp, top = 0.dp),
    verticalArrangement = Arrangement.SpaceBetween,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    GreetingTextPart()
    ProfileNameTitlePart(routeParam)
  }

}

@Composable
private fun ProfileNameTitlePart(
  routeParam: HomeRouteParam
) {
  Text(
    modifier = Modifier.fillMaxWidth(),
    text = routeParam.userData.displayName,
    fontWeight = FontWeight.Bold,
    style = MaterialTheme.typography.headlineLarge,
    maxLines = 1,
    overflow = TextOverflow.Ellipsis,
    textAlign = TextAlign.Start
  )
}

@Composable
private fun GreetingTextPart() {
  Text(
    modifier = Modifier.fillMaxWidth(),
    text = stringResource(R.string.text_home_greeting),
    maxLines = 1,
    style = MaterialTheme.typography.titleMedium,
    textAlign = TextAlign.Start
  )
}
