
package com.maxrave.simpmusic.ui.screen.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.maxrave.simpmusic.ui.component.RippleIconButton
import com.maxrave.simpmusic.ui.icon.ArrowBackIosNew
import com.maxrave.simpmusic.ui.icon.SimpIcons
import com.maxrave.simpmusic.utils.VersionManager
import org.jetbrains.compose.resources.painterResource
import simpmusic.composeapp.generated.resources.Res
import simpmusic.composeapp.generated.resources.app_icon

private val GlassBlue = Color(0xFFB9DFFF)
private val GlassRed = Color(0xFFFF315B)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditScreen(
    paddingValues: PaddingValues,
    navController: NavController,
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF050507),
                        Color(0xFF18070D),
                        Color(0xFF080609)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 75.dp)
                .verticalScroll(scrollState)
                .padding(horizontal = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(18.dp))

            // AURA MUSIC GLASS WORDMARK
            GlassCard {
                Text(
                    text = "AURA | Music",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 25.dp),
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.height(20.dp))

            // ABOUT AURA MUSIC
            GlassCard {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(Res.drawable.app_icon),
                        contentDescription = "AURA Music Logo",
                        modifier = Modifier
                            .size(90.dp)
                            .clip(RoundedCornerShape(22.dp))
                    )

                    Spacer(Modifier.width(16.dp))

                    Column {
                        Text(
                            text = "About AURA Music",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "AURA Music is a modern, fast and feature-rich music player designed for music lovers. Enjoy your favorite songs with a beautiful interface, powerful features and smooth performance.",
                            color = Color(0xFFD6D2DC),
                            fontSize = 14.sp,
                            lineHeight = 21.sp
                        )
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            // APP INFORMATION
            GlassCard {
                Text(
                    text = "ⓘ  App Information",
                    color = Color.White,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(18.dp))

                InfoRow("App Name", "AURA Music")
                InfoRow("Version", VersionManager.getVersionName())
                InfoRow("Developer", "AURA Studio")
            }

            Spacer(Modifier.height(35.dp))
        }

        TopAppBar(
            title = {
                Text(
                    text = "About",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                Box(Modifier.padding(horizontal = 5.dp)) {
                    RippleIconButton(
                        SimpIcons.ArrowBackIosNew,
                        Modifier.size(32.dp),
                        true,
                        tint = Color.White
                    ) {
                        navController.navigateUp()
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            )
        )
    }
}

@Composable
private fun GlassCard(
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(26.dp)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.linearGradient(
                    listOf(
                        Color(0x55424A5B),
                        Color(0x33201825),
                        Color(0x55401020)
                    )
                ),
                shape
            )
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    listOf(GlassBlue, GlassRed, GlassBlue)
                ),
                shape = shape
            )
            .padding(20.dp),
        content = content
    )
}

@Composable
private fun InfoRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = Color(0xFFD0CDDA),
            fontSize = 15.sp,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = ":",
            color = Color.White,
            fontSize = 15.sp
        )

        Text(
            text = value,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .weight(1.35f)
                .padding(start = 12.dp)
        )
    }
}
