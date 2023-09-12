package dev.marlonlom.apps.glucoreo.converter

import org.junit.Assert
import org.junit.Test

internal class MeasurementStatusTest {

  @Test
  fun `Should return error status for negative number`() {
    val actual = MeasurementStatus.single(-1.0)
    Assert.assertEquals("ERROR", actual)
  }

  @Test
  fun `Should return hypoglycemia status for selected number`() {
    val actual = MeasurementStatus.single(40.0)
    Assert.assertEquals(MeasurementStatus.HYPOGLYCEMIA.name, actual)
  }

  @Test
  fun `Should return lower status for selected number`() {
    val actual = MeasurementStatus.single(75.0)
    Assert.assertEquals(MeasurementStatus.LOWER.name, actual)
  }

  @Test
  fun `Should return normal status for selected number`() {
    val actual = MeasurementStatus.single(95.0)
    Assert.assertEquals(MeasurementStatus.NORMAL.name, actual)
  }

  @Test
  fun `Should return higher status for selected number`() {
    val actual = MeasurementStatus.single(155.0)
    Assert.assertEquals(MeasurementStatus.HIGHER.name, actual)
  }

  @Test
  fun `Should return hyperglycemia status for selected number`() {
    val actual = MeasurementStatus.single(190.0)
    Assert.assertEquals(MeasurementStatus.HYPERGLYCEMIA.name, actual)
  }

  @Test
  fun `Should return hyperosmolar hyperglycemic status for selected number`() {
    val actual = MeasurementStatus.single(785.0)
    Assert.assertEquals(MeasurementStatus.HYPEROSMOLAR_HYPERGLYCEMIC.name, actual)
  }
}
