package com.code.quizzo.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp


@Composable
fun CurvedText(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .size(200.dp)
    ) {
        drawIntoCanvas { canvas ->
            val text = "Step-a-thon"
            val paint = android.graphics.Paint().apply {
                isAntiAlias = true
                textSize = 140f
                color = android.graphics.Color.WHITE
                style = android.graphics.Paint.Style.FILL
                textAlign = android.graphics.Paint.Align.CENTER
            }
            val path = android.graphics.Path().apply {
                addArc(
                    0f,
                    0f,
                    size.width,
                    size.height,
                    -180f,
                    180f
                )
            }
            canvas.nativeCanvas.drawTextOnPath(text, path, 0f, 0f, paint)
        }
    }
}

