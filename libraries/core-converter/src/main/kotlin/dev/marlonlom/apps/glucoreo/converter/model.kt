/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.converter

/**
 * Blood glucose measure result data class.
 *
 * @author marlonlom
 *
 * @property unit Result unit.
 * @property value Result value.
 *
 */
data class BloodGlucoseDetail(
  val unit: MeasurementUnits = MeasurementUnits.MGDL,
  val value: Double
) {

  /**
   * Result value as mg/dl.
   */
  val mgdl
    get() = when (unit) {
      MeasurementUnits.MGDL -> value
      else -> GlucoseConverter.toMgdl(value)
    }

  /**
   * Result value as mmol/l.
   */
  val mmoll
    get() = when (unit) {
      MeasurementUnits.MMOLL -> value
      else -> GlucoseConverter.toMmoll(value)
    }

  /**
   * Result status for mgdl value.
   *
   * @see MeasurementStatus
   */
  val status
    get() = MeasurementStatus.single(mgdl)
}

