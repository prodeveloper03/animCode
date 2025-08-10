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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.code.quizzo.R
import com.code.quizzo.ui.components.CurvedText
import com.code.quizzo.ui.components.buttons.NavigationIndicator
import com.code.quizzo.ui.components.buttons.PrimaryActionButton
import kotlinx.coroutines.delay

@Composable
fun StepUpAndScore(
    onNextClick: () -> Unit
) {
    var currentImage by remember { mutableStateOf(R.drawable.image1) }
    var nextImage by remember { mutableStateOf(R.drawable.image3) }
    var animateToCenter by remember { mutableStateOf(false) }

    // Fade out for center image
    val centerAlpha by animateFloatAsState(
        targetValue = if (animateToCenter) 0f else 1f,
        animationSpec = tween(600, easing = FastOutSlowInEasing)
    )

    // Center image scale & offset
    val centerScale by animateFloatAsState(
        targetValue = if (animateToCenter) 0.8f else 1f,
        animationSpec = tween(600, easing = FastOutSlowInEasing)
    )
    val centerOffsetX by animateDpAsState(
        targetValue = if (animateToCenter) (-150).dp else 0.dp,
        animationSpec = tween(600, easing = FastOutSlowInEasing)
    )

    // Right image scale & offset (grows to center)
    val rightScale by animateFloatAsState(
        targetValue = if (animateToCenter) 1f else 0.4f,
        animationSpec = tween(600, easing = FastOutSlowInEasing)
    )
    val rightOffsetX by animateDpAsState(
        targetValue = if (animateToCenter) 0.dp else 150.dp,
        animationSpec = tween(600, easing = FastOutSlowInEasing)
    )
    val animationDuration = 600

    LaunchedEffect(animateToCenter) {
        if (animateToCenter) {
            delay(animationDuration.toLong())
            currentImage = nextImage
            nextImage = R.drawable.image3 // or your next image
            animateToCenter = false
            onNextClick() // call after animation ends
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF5A2DFF))
            .padding(16.dp),
    ) {

        Image(
            painter = painterResource(id = nextImage),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = rightOffsetX, y = (-180).dp)
                .scale(rightScale)
                .size(220.dp)
        )

        Image(
            painter = painterResource(id = currentImage),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = centerOffsetX, y = (-80).dp)
                .scale(centerScale)
                .alpha(centerAlpha)
                .size(520.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            CurvedText()

            Spacer(modifier = Modifier.height(340.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Step Up and Score",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Join the Race, Lace Up, and",
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    color = Color.White.copy(alpha = 0.85f)
                )
                Text(
                    text = "Embrace Health!",
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    color = Color.White.copy(alpha = 0.85f),
                    textAlign = TextAlign.Center
                )
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                NavigationIndicator(totalSteps = 3, currentStep = 0)
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
fun TestStepUpAndScore(){
    StepUpAndScore (
        onNextClick = {}
    )
}