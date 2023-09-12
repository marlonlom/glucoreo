package dev.marlonlom.apps.glucoreo.onboarding

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.marlonlom.apps.glucoreo.R

/**
 * Profile completion message composable ui.
 *
 * @author marlonlom
 */
@Composable
fun ProfileCompletionMessage() {
  Text(
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 10.dp, bottom = 20.dp)
      .padding(horizontal = 10.dp),
    text = stringResource(R.string.text_onboarding_completion_message),
    textAlign = TextAlign.Start,
    style = MaterialTheme.typography.bodyMedium,
    color = MaterialTheme.colorScheme.onSecondaryContainer
  )
}

/**
 * Onboarding profile form section composable ui.
 *
 * @author marlonlom
 *
 * @param sectionTitle Text title for section.
 * @param content composable ui content.
 */
@ExperimentalMaterial3Api
@Composable
fun ProfileFormSection(
  @StringRes sectionTitle: Int,
  content: @Composable () -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)
  ) {
    Text(
      modifier = Modifier.paddingFromBaseline(top = 20.dp, bottom = 8.dp),
      text = stringResource(id = sectionTitle),
      fontWeight = FontWeight.Bold,
      style = MaterialTheme.typography.titleMedium,
      maxLines = 1
    )
    content()
  }
}

/**
 * User genres chip group composable ui.
 *
 * @author marlonlom
 *
 * @param genres Genres list.
 * @param state Onboarding ui state.
 */
@ExperimentalMaterial3Api
@Composable
fun UserGenreChipGroup(
  genres: List<UserGenre> = UserGenre.values(),
  state: UserProfileDataUiState
) {
  LazyRow(
    horizontalArrangement = Arrangement.spacedBy(10.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    items(genres) {
      FilterChip(
        selected = state.genre == it.name,
        onClick = { state.changeGenre(it.name) },
        label = {
          Text(
            text = stringResource(id = it.label),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
          )
        },
        border = FilterChipDefaults.filterChipBorder(
          borderWidth = 2.dp,
          selectedBorderWidth = 2.dp,
          borderColor = MaterialTheme.colorScheme.secondary,
          selectedBorderColor = MaterialTheme.colorScheme.secondary
        ),
        leadingIcon = {
          Image(
            modifier = Modifier.size(22.dp),
            painter = painterResource(id = it.imageRes),
            contentDescription = null
          )
        }
      )
    }
  }
}

/**
 * User Diabetes types chip group composable ui.
 *
 * @author marlonlom
 *
 * @param diabetesTypes Diabetes types list.
 * @param state Onboarding ui state.
 */
@ExperimentalMaterial3Api
@Composable
fun UserDiabetesTypeChipGroup(
  diabetesTypes: List<DiabetesType> = DiabetesType.values(),
  state: UserProfileDataUiState
) {
  LazyRow(
    horizontalArrangement = Arrangement.spacedBy(10.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    items(diabetesTypes) {
      FilterChip(
        selected = state.diabetesType == it.name,
        onClick = { state.changeDiabetesType(it.name) },
        label = {
          Text(
            text = stringResource(id = it.label),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
          )
        },
        border = FilterChipDefaults.filterChipBorder(
          borderWidth = 2.dp,
          selectedBorderWidth = 2.dp,
          borderColor = MaterialTheme.colorScheme.secondary,
          selectedBorderColor = MaterialTheme.colorScheme.secondary,
        )
      )
    }
  }
}

/**
 * User Age ranges chip group composable ui.
 *
 * @author marlonlom
 *
 * @param ageRanges Age ranges list.
 * @param state Onboarding ui state.
 */
@ExperimentalMaterial3Api
@Composable
fun UserAgeChipGroup(
  ageRanges: List<AgeRange> = AgeRange.values(),
  state: UserProfileDataUiState
) {
  LazyRow(
    horizontalArrangement = Arrangement.spacedBy(10.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    items(ageRanges) {
      FilterChip(
        selected = state.age == it.name,
        onClick = { state.changeAge(it.name) },
        label = {
          Text(
            text = stringResource(id = it.label),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
          )
        },
        border = FilterChipDefaults.filterChipBorder(
          borderWidth = 2.dp,
          selectedBorderWidth = 2.dp,
          borderColor = MaterialTheme.colorScheme.secondary,
          selectedBorderColor = MaterialTheme.colorScheme.secondary
        )
      )
    }
  }
}

/**
 * Measurement unit chip group composable ui.
 *
 * @author marlonlom
 *
 * @param units Measurement units list.
 * @param state Onboarding ui state.
 */
@ExperimentalMaterial3Api
@Composable
fun MeasurementUnitChipGroup(
  units: List<MeasurementUnit> = MeasurementUnit.values(),
  state: UserProfileDataUiState
) {
  LazyRow(
    horizontalArrangement = Arrangement.spacedBy(10.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    items(units) {
      FilterChip(
        selected = state.unit == it.name,
        onClick = { state.changeMeasurementUnit(it.name) },
        label = {
          Text(
            text = stringResource(id = it.label),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
          )
        },
        border = FilterChipDefaults.filterChipBorder(
          borderWidth = 2.dp,
          selectedBorderWidth = 2.dp,
          borderColor = MaterialTheme.colorScheme.secondary,
          selectedBorderColor = MaterialTheme.colorScheme.secondary
        )
      )
    }
  }
}

/**
 * Save profile button composable ui.
 *
 * @author marlonlom
 *
 * @param routeParam Onboarding route screen composable ui parameters.
 * @param state Onboarding ui state.
 */
@Composable
fun SaveProfileButton(
  routeParam: OnboardingRouteParam,
  state: UserProfileDataUiState
) {

  val buttonModifier = when {
    routeParam.windowSizes.isTabletWidth -> Modifier.width(200.dp)
    else -> Modifier.fillMaxWidth()
  }

  Button(
    enabled = state.isReady(),
    shape = RoundedCornerShape(10.dp),
    colors = ButtonDefaults.buttonColors(
      containerColor = MaterialTheme.colorScheme.primaryContainer,
      contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ),
    modifier = buttonModifier.padding(vertical = 10.dp),
    onClick = {
      routeParam.onSaveButtonClicked(state.toUserProfileData())
    },
  ) {
    Text(
      text = stringResource(R.string.text_onboarding_button_save),
      fontWeight = FontWeight.Bold,
      style = MaterialTheme.typography.titleSmall
    )
  }
}
