package com.code.quizzo.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.code.quizzo.R
import com.code.quizzo.ui.components.CurvedText
import com.code.quizzo.ui.components.RotatingBackgroundImage
import com.code.quizzo.ui.components.buttons.NavigationIndicator
import com.code.quizzo.ui.components.buttons.PrimaryActionButton

@Composable
fun FinalVictory(
    onFinishClick: () -> Unit
) {
    var animateScale by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (animateScale) 1f else 0.8f,
        animationSpec = tween(durationMillis = 800)
    )

    LaunchedEffect(Unit) {
        animateScale = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFF754C),
                        Color(0xFFE31E71)
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

            Spacer(modifier = Modifier.height(40.dp))

            CurvedText()

            Image(
                painter = painterResource(id = R.drawable.image2),
                contentDescription = null,
                modifier = Modifier
                    .scale(scale)
                    .size(420.dp)
                    .offset(y=(-20.dp))
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Final Victory",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "You’ve conquered all challenges!",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.85f)
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                NavigationIndicator(
                    totalSteps = 3,
                    currentStep = 2
                )
                Spacer(modifier = Modifier.height(16.dp))
                PrimaryActionButton(
                    text = "Finish",
                    onClick = onFinishClick
                )
            }
        }
    }
}

@Preview
@Composable
fun TestFinalVictory(){
    FinalVictory(
        onFinishClick = {}
    )
}