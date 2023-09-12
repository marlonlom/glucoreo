/*
 * Copyright 2023 Marlonlom
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.marlonlom.apps.glucoreo.ui.signin

import android.app.Activity
import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInCredential
import dev.marlonlom.apps.glucoreo.BuildConfig
import dev.marlonlom.apps.glucoreo.onboarding.UserAccountData
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import java.util.UUID

@Composable
fun obtainOneTapSigninLauncher(
  activity: Activity,
  onSignInSuccess: (UserAccountData) -> Unit,
  onSignInFailed: () -> Unit,
) = rememberLauncherForActivityResult(
  ActivityResultContracts.StartIntentSenderForResult()
) { result ->

  when (result.resultCode) {
    Activity.RESULT_OK -> {
      val oneTapClient = Identity.getSignInClient(activity)
      val credential: SignInCredential = oneTapClient.getSignInCredentialFromIntent(result.data)
      val idToken = credential.googleIdToken
      if (idToken != null) {
        val userAccountData = credential.let {
          UserAccountData(
            UUID.nameUUIDFromBytes(it.id.encodeToByteArray()).toString().replace("-", ""),
            it.displayName!!,
            it.profilePictureUri.toString(),
            it.id
          )
        }

        onSignInSuccess(userAccountData)
      } else {
        onSignInFailed()
      }
    }

    else -> {
      if (result.data?.action == ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST) {
        @Suppress("DEPRECATION")
        val exception: Exception? =
          result.data?.getSerializableExtra(
            ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION
          ) as Exception?
        Timber.e("[obtainOneTapSigninLauncher] Couldn't start One Tap UI: ${exception?.localizedMessage}")
      }
      return@rememberLauncherForActivityResult
    }
  }
}

suspend fun doSignIn(
  context: Context,
  launcher: ActivityResultLauncher<IntentSenderRequest>
) {
  val oneTapClient = Identity.getSignInClient(context)
  val signInRequest = BeginSignInRequest.builder()
    .setGoogleIdTokenRequestOptions(
      BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
        .setSupported(true)
        .setServerClientId(BuildConfig.GSI_WEB_CLIENT_ID)
        .setFilterByAuthorizedAccounts(false)
        .build()
    )
    .setAutoSelectEnabled(true)
    .build()

  try {
    val result = oneTapClient.beginSignIn(signInRequest).await()
    val intentSenderRequest = IntentSenderRequest.Builder(result.pendingIntent).build()
    launcher.launch(intentSenderRequest)
  } catch (e: Exception) {
    Timber.d("[doSignIn] exception=${e.message.toString()}")
  }
}
