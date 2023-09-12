/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.converter

import org.junit.Assert.assertEquals
import org.junit.Test

internal class BloodGlucoseDetailTest {

  @Test
  fun `Should obtain mgdl conversion result`() {
    val expectedMgdl = 70.0
    val expectedMmoll = 3.88
    val result = BloodGlucoseDetail(
      unit = MeasurementUnits.MGDL,
      value = expectedMgdl
    )
    assertEquals(expectedMgdl, result.mgdl, 0.0)
    assertEquals(expectedMmoll, result.mmoll, 0.0)
    assertEquals(MeasurementStatus.LOWER.name, result.status)
  }

  @Test
  fun `Should obtain mmoll conversion result`() {
    val expectedMgdl = 180.0
    val expectedMmoll = 10.0
    val result = BloodGlucoseDetail(
      unit = MeasurementUnits.MMOLL,
      value = expectedMmoll
    )
    assertEquals(expectedMgdl, result.mgdl, 0.0)
    assertEquals(expectedMmoll, result.mmoll, 0.0)
    assertEquals(MeasurementStatus.HIGHER.name, result.status)
  }

  @Test
  fun `Should obtain error conversion result using negative number`() {
    val expectedMgdl = -6.0
    val expectedMmoll = -0.34
    val result = BloodGlucoseDetail(
      unit = MeasurementUnits.MGDL,
      value = expectedMgdl
    )
    assertEquals(expectedMgdl, result.mgdl, 0.0)
    assertEquals(expectedMmoll, result.mmoll, 0.0)
    assertEquals("ERROR", result.status)
  }
}
