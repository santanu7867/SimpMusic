
package com.maxrave.simpmusic

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import simpmusic.composeapp.generated.resources.Res
import simpmusic.composeapp.generated.resources.aura_splash


@Composable
fun AuraSplashScreen() {
    val alpha = remember { Animatable(0f) }
    val scale = remember { Animatable(1.02f) }

    LaunchedEffect(Unit) {
        alpha.animateTo(1f, tween(4000))
    }

    LaunchedEffect(Unit) {
        scale.animateTo(1f, tween(4000))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.aura_splash),
            contentDescription = "AURA Music Splash Screen",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    this.alpha = alpha.value
                    scaleX = scale.value
                    scaleY = scale.value
                },
            contentScale = ContentScale.Crop
        )
    }
}
