package dev.marlonlom.apps.glucoreo.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

/**
 * User profile data ui state class.
 *
 * @author marlonlom
 *
 * @property uid User unique identifier.
 *
 * @constructor
 * Constructs an instance for this ui state class holder.
 *
 * @param initialGenre Initial value for current user's genre.
 * @param initialAge Initial value for current user's age.
 * @param initialDiabetesType Initial value for current user's diabetes type.
 */
class UserProfileDataUiState(
  private val uid: String,
  initialGenre: String,
  initialAge: String,
  initialDiabetesType: String,
  initialMeasurementUnit: String,
) {
  /** Current genre as mutable ui state. */
  var genre by mutableStateOf(initialGenre)
    private set

  /** Current age as mutable ui state. */
  var age by mutableStateOf(initialAge)
    private set

  /** Current diabetes type as mutable ui state. */
  var diabetesType by mutableStateOf(initialDiabetesType)
    private set

  /** Current glucose measurement unit as mutable ui state. */
  var unit by mutableStateOf(initialMeasurementUnit)
    private set

  /**
   * Updates genre text.
   *
   * @param newGenre New genre text.
   */
  fun changeGenre(newGenre: String) {
    genre = newGenre
  }

  /**
   * Updates age text.
   *
   * @param newAge New age text.
   */
  fun changeAge(newAge: String) {
    age = newAge
  }

  /**
   * Updates diabetes type text.
   *
   * @param newDiabetesType New diabetes type text.
   */
  fun changeDiabetesType(newDiabetesType: String) {
    diabetesType = newDiabetesType
  }

  /**
   * Updates measurement unit text.
   *
   * @param newMeasurementUnit New measurement unit text.
   */
  fun changeMeasurementUnit(newMeasurementUnit: String) {
    unit = newMeasurementUnit
  }

  /**
   * Returns true/false if ui state is ready and all information (genre, age, diabetes type) is not empty.
   *
   * @return true/false
   */
  fun isReady() = listOf(genre, age, diabetesType, unit).all { it.isNotEmpty() }

  /**
   * Returns a new instance of user profile data class using state values (genre, age, diabetes type).
   *
   * @return new instance of user profile data class.
   */
  fun toUserProfileData() = UserProfileData(
    uid = uid,
    genre = genre,
    ageRange = age,
    diabetesType = diabetesType,
    measurementUnit = unit
  )

  companion object {
    val Saver: Saver<UserProfileDataUiState, *> = listSaver(
      save = { listOf(it.uid, it.genre, it.age, it.diabetesType, it.unit) },
      restore = {
        UserProfileDataUiState(
          uid = it[0],
          initialGenre = it[1],
          initialAge = it[2],
          initialDiabetesType = it[3],
          initialMeasurementUnit = it[4],
        )
      },
    )
  }
}

/**
 * TComposable for remembering user profile data ui state.
 *
 * @param userUid
 * @param initialGenre
 * @param initialAge
 * @param initialDiabetesType
 * @param initialMeasurementUnit
 *
 * @return Ui State for user profile data.
 */
@Composable
fun rememberUserProfileDataUiState(
  userUid: String,
  initialGenre: String = "",
  initialAge: String = "",
  initialDiabetesType: String = "",
  initialMeasurementUnit: String = "",
): UserProfileDataUiState = rememberSaveable(
  userUid,
  saver = UserProfileDataUiState.Saver,
) {
  UserProfileDataUiState(
    uid = userUid,
    initialGenre = initialGenre,
    initialAge = initialAge,
    initialDiabetesType = initialDiabetesType,
    initialMeasurementUnit = initialMeasurementUnit
  )
}
