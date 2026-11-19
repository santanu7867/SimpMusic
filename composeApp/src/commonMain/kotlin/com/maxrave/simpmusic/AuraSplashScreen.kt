package com.maxrave.simpmusic

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AuraSplashScreen() {
    val red = Color(0xFFFF1738)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF4A0714),
                        Color(0xFF19050A),
                        Color(0xFF080808)
                    ),
                    center = Offset(500f, 650f),
                    radius = 1000f
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.size(190.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                red.copy(alpha = 0.35f),
                                Color.Transparent
                            )
                        ),
                        radius = size.minDimension / 2
                    )
                    drawCircle(
                        color = red.copy(alpha = 0.85f),
                        radius = size.minDimension * 0.39f,
                        style = Stroke(width = 3.dp.toPx())
                    )
                    drawCircle(
                        color = Color.White.copy(alpha = 0.25f),
                        radius = size.minDimension * 0.46f,
                        style = Stroke(width = 1.dp.toPx())
                    )
                }

                Text(
                    text = "A",
                    color = Color.White,
                    fontSize = 100.sp,
                    fontWeight = FontWeight.Black
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "AURA MUSIC",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 5.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.height(30.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf(12, 22, 30, 18, 26, 12, 22).forEach { bar ->
                    Box(
                        modifier = Modifier
                            .width(4.dp)
                            .height(bar.dp)
                            .background(red, CircleShape)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "FEEL THE MUSIC",
                color = Color.LightGray,
                fontSize = 11.sp,
                letterSpacing = 4.sp
            )
        }
    }
}
