package dev.marlonlom.apps.glucoreo.ui.timber

import android.util.Log
import timber.log.Timber

class CrashReportingTree : Timber.Tree() {

  override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
    if (isPriorityVerboseOrDebug(priority)) {
      return
    }
  }

  private fun isPriorityVerboseOrDebug(
    priority: Int
  ) = listOf(
    Log.VERBOSE, Log.DEBUG
  ).contains(priority)
}
