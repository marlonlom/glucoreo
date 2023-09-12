/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.marlonlom.apps.glucoreo.R

@Composable
fun ProfileHeadingSection(
  routeParam: OnboardingRouteParam
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 20.dp)
      .border(
        width = 2.dp,
        color = MaterialTheme.colorScheme.tertiary,
        shape = RoundedCornerShape(10.dp)
      )
      .clip(RoundedCornerShape(10.dp))
      .background(MaterialTheme.colorScheme.tertiaryContainer),
    horizontalArrangement = Arrangement.spacedBy(20.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    AsyncImage(
      model = ImageRequest.Builder(LocalContext.current)
        .data(routeParam.userData.photoUrl)
        .crossfade(true)
        .build(),
      placeholder = painterResource(R.drawable.img_default_account),
      contentDescription = null,
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .size(72.dp)
        .padding(10.dp)
        .border(
          width = 2.dp,
          color = MaterialTheme.colorScheme.secondary,
          shape = CircleShape
        )
        .clip(CircleShape)
    )
    Text(
      modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
        .padding(end = 20.dp),
      text = routeParam.userData.displayName,
      fontWeight = FontWeight.Bold,
      style = MaterialTheme.typography.titleLarge,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      textAlign = TextAlign.Start
    )
  }
}
