package dev.marlonlom.apps.glucoreo.converter

import dev.marlonlom.apps.glucoreo.converter.GlucoseConverterResult.Failure
import dev.marlonlom.apps.glucoreo.converter.GlucoseConverterResult.NegativeGlucoseAmountException
import dev.marlonlom.apps.glucoreo.converter.GlucoseConverterResult.Success
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

internal class GlucoseConverterTest {

  @Test
  fun `Should success converting zero value`() {
    val result = GlucoseConverter.convert(0.0, MeasurementUnits.MGDL)
    when {
      (result is Success) -> {
        assertNotNull(result.data)
      }

      else -> {
        fail()
      }
    }
  }

  @Test
  fun `Should fail converting negative values`() {
    val result = GlucoseConverter.convert(-1.0, MeasurementUnits.MGDL)
    when {
      (result is Failure) -> {
        assertTrue(result.error is NegativeGlucoseAmountException)
      }

      else -> {
        fail()
      }
    }
  }
}
