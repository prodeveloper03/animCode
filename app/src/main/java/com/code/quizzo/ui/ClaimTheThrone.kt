package com.code.quizzo.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.code.quizzo.R
import com.code.quizzo.ui.components.CurvedText
import com.code.quizzo.ui.components.RotatingBackgroundImage
import com.code.quizzo.ui.components.buttons.NavigationIndicator
import com.code.quizzo.ui.components.buttons.PrimaryActionButton
import kotlinx.coroutines.delay

@Composable
fun ClaimTheThrone(
    onNextClick: () -> Unit
) {
    var animateToCenter by remember { mutableStateOf(false) }

    val imageScale by animateFloatAsState(
        targetValue = if (animateToCenter) 0.8f else 1f,
        animationSpec = tween(600, easing = FastOutSlowInEasing)
    )
    val imageAlpha by animateFloatAsState(
        targetValue = if (animateToCenter) 0f else 1f,
        animationSpec = tween(600, easing = FastOutSlowInEasing)
    )
    val imageOffsetY by animateDpAsState(
        targetValue = if (animateToCenter) (-50).dp else 0.dp,
        animationSpec = tween(600, easing = FastOutSlowInEasing)
    )

    LaunchedEffect(animateToCenter) {
        if (animateToCenter) {
            delay(600)
            animateToCenter = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF42DEC5),
                        Color(0xFF3484DE)
                    ),
                    center = Offset.Unspecified,
                    radius = 1000f
                )
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        RotatingBackgroundImage()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            CurvedText()

            Image(
                painter = painterResource(id = R.drawable.image3),
                contentDescription = null,
                modifier = Modifier
                    .scale(imageScale)
                    .alpha(imageAlpha)
                    .offset(y = imageOffsetY)
                    .size(320.dp)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Claim the Throne",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Compete with your colleagues for Top",
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                    Text(
                        text = "Ranks",
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        color = Color.White.copy(alpha = 0.85f),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                NavigationIndicator(
                    totalSteps = 3,
                    currentStep = 1
                )
                Spacer(modifier = Modifier.height(16.dp))
                PrimaryActionButton(
                    text = "Next",
                    onClick = {
                        animateToCenter = true
                        onNextClick()
                    }
                )
            }
        }
    }
}


@Preview
@Composable
fun TestClaimTheThroneClaimTheThrone(){
   ClaimTheThrone(
       onNextClick = {}
   )
}