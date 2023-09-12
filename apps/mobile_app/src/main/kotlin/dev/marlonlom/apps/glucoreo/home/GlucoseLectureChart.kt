package dev.marlonlom.apps.glucoreo.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun GlucoseLectureChart(
  routeParam: HomeRouteParam
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(bottom = 20.dp)
      .border(
        width = 2.dp,
        color = MaterialTheme.colorScheme.tertiary,
        shape = RoundedCornerShape(10.dp)
      )
      .clip(RoundedCornerShape(10.dp))
      .background(MaterialTheme.colorScheme.tertiaryContainer),
  ) {
    Spacer(modifier = Modifier.height(160.dp))
  }
}
