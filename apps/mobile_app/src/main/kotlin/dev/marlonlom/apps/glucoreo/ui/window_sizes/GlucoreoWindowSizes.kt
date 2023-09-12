package dev.marlonlom.apps.glucoreo.ui.window_sizes

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

/**
 * Window size checking utility class.
 *
 * @author marlonlom
 *
 * @property wsc Window size class object reference.
 */
class GlucoreoWindowSizes(
  private val wsc: WindowSizeClass
) {

  /**
   * Returns true/false if window sizes belong to mobile landscape.
   */
  val isMobileLandscape
    get() = (
      wsc.widthSizeClass == WindowWidthSizeClass.Expanded
      ).and(
        wsc.heightSizeClass == WindowHeightSizeClass.Compact
      )


  /**
   * Returns true/false if window sizes belong to tablet landscape.
   */
  val isTabletWidth
    get() = arrayOf(
      WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded
    ).contains(wsc.widthSizeClass)

  /**
   * Returns true/false if window sizes belong to tablet landscape.
   */
  val isTabletLandscape
    get() = (
      wsc.widthSizeClass == WindowWidthSizeClass.Expanded
      ).and(
        wsc.heightSizeClass == WindowHeightSizeClass.Medium
      )
}
