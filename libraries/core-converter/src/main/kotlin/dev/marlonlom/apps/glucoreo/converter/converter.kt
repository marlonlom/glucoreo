package dev.marlonlom.apps.glucoreo.converter

import dev.marlonlom.apps.glucoreo.converter.GlucoseConverterResult.Failure
import dev.marlonlom.apps.glucoreo.converter.GlucoseConverterResult.NegativeGlucoseAmountException
import dev.marlonlom.apps.glucoreo.converter.GlucoseConverterResult.Success
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Glucose converter utility singleton object.
 *
 * @author marlonlom
 */
object GlucoseConverter {

  /**
   * Performs conversion for provided glucose reading value and unit.
   *
   * @param value Blood glucose level read value.
   * @param unit Blood glucose measurement unit.
   *
   * @return Glucose convert result.
   *
   * @see MeasurementUnits
   * @see GlucoseConverterResult
   */
  fun convert(
    value: Double,
    unit: MeasurementUnits
  ): GlucoseConverterResult = when {
      (value < 0)-> {
        Failure(
          NegativeGlucoseAmountException()
        )
      }
      else -> Success(
        BloodGlucoseDetail(
          unit = unit,
          value = value
        )
      )
  }

  /**
   * Calculate mmol/l from mg/dl.
   *
   * @param mgdl value for converting.
   *
   * @return conversion result as mmol/l.
   */
  fun toMmoll(mgdl: Double): Double = roundExactTwoDecimals(mgdl / 18.0)

  /**
   * Calculate mg/dl from mmol/l.
   *
   * @param mmoll value for converting.
   *
   * @return conversion result as mg/dl.
   */
  fun toMgdl(mmoll: Double): Double = roundExactTwoDecimals(mmoll * 18.0)

  /**
   * Performs number rounding using exactly two decimals.
   *
   * @param num Number for being rounded.
   *
   * @return converted number.
   */
  private fun roundExactTwoDecimals(num: Double): Double {
    if (num == 0.0) {
      return 0.0
    }
    val bigDecimal = BigDecimal(num)
    return bigDecimal.setScale(2, RoundingMode.FLOOR).toDouble()
  }
}

/**
 * Glucose converter result sealed class that contains failure and success result.
 *
 * @author marlonlom
 *
 */
sealed class GlucoseConverterResult {

  /**
   * Negative glucose amount exception class.
   *
   * @author marlonlom
   *
   */
  class NegativeGlucoseAmountException : RuntimeException()

  /**
   * Failure state representation for glucose conversion result.
   *
   * @author marlonlom
   *
   * @property error Runtime exception related to error.
   */
  data class Failure(
    val error: RuntimeException
  ) : GlucoseConverterResult()

  /**
   * Success state representation for glucose conversion result.
   *
   * @author marlonlom
   *
   * @property data Detailed information for result.
   */
  data class Success(
    val data: BloodGlucoseDetail
  ) : GlucoseConverterResult()

}
