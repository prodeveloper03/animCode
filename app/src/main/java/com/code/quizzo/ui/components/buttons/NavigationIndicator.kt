package com.code.quizzo.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NavigationIndicator(
    totalSteps: Int,
    currentStep: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(totalSteps) { index ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(if (index == currentStep) 12.dp else 8.dp)
                    .clip(CircleShape)
                    .background(
                        if (index == currentStep) Color.White else Color.White.copy(alpha = 0.4f)
                    )
            )
        }
    }
}

@Composable
@Preview
fun Test(){
    NavigationIndicator(
        totalSteps = 2,
        currentStep = 1
    )
}
