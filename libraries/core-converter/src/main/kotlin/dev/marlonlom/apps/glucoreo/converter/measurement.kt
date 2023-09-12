package dev.marlonlom.apps.glucoreo.converter

/**
 * Measurement units enum class.
 *
 * @author marlonlom
 *
 * @property unitText text for measurement unit.
 */
enum class MeasurementUnits(
  private val unitText: String
) {
  MGDL("mg/dl"),
  MMOLL("mmol/l")
}

/**
 * Measurement status check interface definition.
 *
 * @author marlonlom
 *
 */
interface MeasurementStatusChecker {

  /**
   * Checks for measurement status using a numeric value in mg/dl.
   *
   * @param mgdl value for comparison.
   *
   * @return true/false
   */
  fun isInStatus(mgdl: Double): Boolean
}

/**
 * Measurement status enum class.
 *
 * @author marlonlom
 *
 */
enum class MeasurementStatus : MeasurementStatusChecker {

  /**
   * Hypoglycemia status enum entry.
   */
  HYPOGLYCEMIA {
    override fun isInStatus(mgdl: Double): Boolean = mgdl < 70
  },

  /**
   * Lower status enum entry.
   */
  LOWER {
    override fun isInStatus(mgdl: Double): Boolean = mgdl <= 80
  },

  /**
   * Normal status enum entry.
   */
  NORMAL {
    override fun isInStatus(mgdl: Double): Boolean = between(mgdl, 80.0, 130.0)
  },

  /**
   * Higher status enum entry.
   */
  HIGHER {
    override fun isInStatus(mgdl: Double): Boolean = between(mgdl, 130.0, 180.0)
  },

  /**
   * Hyperglycemia status enum entry.
   */
  HYPERGLYCEMIA {
    override fun isInStatus(mgdl: Double): Boolean = between(mgdl, 180.0, 600.0)
  },

  /**
   * Hyperosmolar hyperglycemic status enum entry.
   */
  HYPEROSMOLAR_HYPERGLYCEMIC {
    override fun isInStatus(mgdl: Double): Boolean = mgdl > 600
  };

  companion object {

    /**
     * Finds a single enum entry for measurement status.
     *
     * @param mgdl Numeric value for finding status.
     */
    fun single(mgdl: Double) = when {
      mgdl >= 0 -> values().find { it.isInStatus(mgdl) }?.name ?: "ERROR"
      else -> "ERROR"
    }

  }
}

/**
 * Checks if a number is between min and max values.
 *
 * @param num Selected number for checks if inside range.
 * @param min Minimum value for range.
 * @param max Maximum value for range.
 */
internal fun between(
  num: Double,
  min: Double,
  max: Double
) = (num > min).and(num <= max)
