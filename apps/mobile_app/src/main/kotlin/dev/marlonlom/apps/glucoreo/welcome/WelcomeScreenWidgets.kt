package dev.marlonlom.apps.glucoreo.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import dev.marlonlom.apps.glucoreo.R
import dev.marlonlom.apps.glucoreo.ui.theme.GlucoreoColors

@Composable
fun WelcomeDescription() {
  Text(
    text = buildAnnotatedString {
      withStyle(
        style = SpanStyle(
          fontStyle = FontStyle.Normal
        )
      ) {
        append("${stringResource(R.string.text_welcome_description_1)} ")
      }
      withStyle(
        style = SpanStyle(
          fontWeight = FontWeight.Bold
        )
      ) {
        append(stringResource(R.string.app_name))
      }
      withStyle(
        style = SpanStyle(
          fontStyle = FontStyle.Normal
        )
      ) {
        append(" ${stringResource(R.string.text_welcome_description_2)} \n")
      }
      withStyle(
        style = SpanStyle(
          fontStyle = FontStyle.Normal
        )
      ) {
        append(stringResource(R.string.text_welcome_description_3))
      }
    },
    modifier = Modifier
      .fillMaxWidth()
      .padding(20.dp),
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.bodyLarge,
  )
}

@Composable
fun GoogleSignInButton(
  onGoogleSignInButtonClicked: () -> Unit
) {
  Button(
    modifier = Modifier.padding(20.dp),
    onClick = {
      onGoogleSignInButtonClicked()
    },
    colors = ButtonDefaults.buttonColors(
      contentColor = GlucoreoColors.white,
      containerColor = MaterialTheme.colorScheme.scrim
    ),
    shape = RoundedCornerShape(24.dp),
    border = BorderStroke(
      width = 1.dp,
      color = GlucoreoColors.white
    ),
  ) {
    Image(
      painterResource(
        id = R.drawable.img_google_logo_24px
      ),
      contentDescription = stringResource(
        R.string.text_welcome_signin_btn_content_description
      ),
      modifier = Modifier.size(20.dp)
    )
    Text(
      modifier = Modifier.padding(horizontal = 10.dp),
      text = stringResource(R.string.text_welcome_signin_btn)
    )
  }
}

@Composable
fun WelcomeImage() {
  Image(
    modifier = Modifier
      .width(114.dp)
      .height(120.dp),
    painter = painterResource(R.drawable.img_welcome_logo),
    contentDescription = stringResource(R.string.text_welcome_image_content_description)
  )
}

@Composable
fun WelcomeTitle() {
  Text(
    text = stringResource(R.string.text_welcome_title),
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp),
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.headlineLarge,
    fontWeight = FontWeight.Bold
  )
}
