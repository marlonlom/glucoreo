/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo

import android.app.Application
import dev.marlonlom.apps.glucoreo.ui.timber.CrashReportingTree
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * Glucoreo Application class.
 *
 * @author marlonlom
 *
 */
class GlucoreoApp : Application() {
  override fun onCreate() {
    super.onCreate()
    setupTimber()
  }

  private fun setupTimber() {
    val tree = if (BuildConfig.DEBUG) DebugTree() else CrashReportingTree()
    Timber.plant(tree)
  }
}
