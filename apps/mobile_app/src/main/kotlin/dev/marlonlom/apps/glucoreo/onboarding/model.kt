/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.marlonlom.apps.glucoreo.R
import dev.marlonlom.apps.glucoreo.converter.MeasurementUnits

/**
 * User account data class.
 *
 * @author marlonlom
 *
 * @property uid Returns a string used to uniquely identify the user.
 * @property displayName Returns the main display name of the user.
 * @property photoUrl Returns the URL of this user's main profile picture.
 * @property email Returns the main email address of the user.
 */
data class UserAccountData(
  val uid: String,
  val displayName: String,
  val photoUrl: String,
  val email: String,
)

/**
 * User profile data class.
 *
 * @author marlonlom
 *
 *
 * @property uid Returns a string used to uniquely identify the user.
 * @property genre Returns a string used to uniquely identify the user's genre.
 * @property ageRange Returns a string used to uniquely identify the user's age range.
 * @property diabetesType Returns a string used to uniquely identify the user's diabetes type.
 * @property measurementUnit Returns a string used to uniquely identify the user's glucose measurement unit.
 */
data class UserProfileData(
  val uid: String,
  val genre: String,
  val ageRange: String,
  val diabetesType: String,
  val measurementUnit: String,
)

/**
 * Diabetes type sealed class.
 *
 * @property name Name text.
 * @property label Label text.
 */
sealed class DiabetesType(
  val name: String,
  @StringRes val label: Int
) {

  object TypeOne : DiabetesType(
    name = "type 1",
    label = R.string.text_diabetes_type_1
  )

  object TypeTwo : DiabetesType(
    name = "type 2",
    label = R.string.text_diabetes_type_2
  )

  object Gestational : DiabetesType(
    name = "gestational",
    label = R.string.text_diabetes_gestational
  )

  companion object {
    fun values() = listOf(TypeOne, TypeTwo, Gestational)
  }
}

/**
 * User genre sealed class.
 *
 * @property name Name text.
 * @property label Label text.
 * @property imageRes Image resource identifier.
 */
sealed class UserGenre(
  val name: String,
  @StringRes val label: Int,
  @DrawableRes val imageRes: Int
) {

  object Male : UserGenre(
    name = "male",
    label = R.string.text_genre_male,
    imageRes = R.drawable.img_genre_male,
  )

  object Female : UserGenre(
    name = "female",
    label = R.string.text_genre_female,
    imageRes = R.drawable.img_genre_female
  )

  companion object {
    fun values(): List<UserGenre> = listOf(Male, Female)
  }
}

/**
 * User age range sealed class.
 *
 * @property name Name text.
 * @property label Label text.
 */
sealed class AgeRange(
  val name: String,
  @StringRes val label: Int,
) {
  object YoungOne : AgeRange("18_26", R.string.text_age_range_01)
  object AdultOne : AgeRange("27_35", R.string.text_age_range_02)
  object AdultTwo : AgeRange("36_44", R.string.text_age_range_03)
  object AdultThree : AgeRange("45_53", R.string.text_age_range_04)
  object OlderOne : AgeRange("54_62", R.string.text_age_range_05)
  object OlderTwo : AgeRange("62_MORE", R.string.text_age_range_06)

  companion object {
    fun values() = listOf(YoungOne, AdultOne, AdultTwo, AdultThree, OlderOne, OlderTwo)
  }
}

/**
 * User glucose lecture measurement unit sealed class.
 *
 * @property name Name text.
 * @property label Label text.
 */
sealed class MeasurementUnit(
  val name: String,
  @StringRes val label: Int,
) {

  object US : MeasurementUnit(
    name = MeasurementUnits.MGDL.name,
    label = R.string.text_units_mgdl
  )

  object UK : MeasurementUnit(
    name = MeasurementUnits.MMOLL.name,
    label = R.string.text_units_mmoll
  )

  companion object {
    fun values() = listOf(US, UK)
  }
}
