package com.geeksforgeeks.roundedcornerpolygon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Rounded Corner Polygon", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        Canvas(modifier = Modifier.fillMaxWidth().aspectRatio(1f)) {
                            val rect = Rect(Offset.Zero, size)
                            val trianglePath = Path().apply {
                                moveTo(rect.topCenter.x, rect.topCenter.y)
                                lineTo(rect.bottomRight.x, rect.bottomRight.y)
                                lineTo(rect.bottomLeft.x, rect.bottomLeft.y)
                                close()
                            }

                            drawIntoCanvas { canvas ->
                                canvas.drawOutline(
                                    outline = Outline.Generic(trianglePath),
                                    paint = Paint().apply {
                                        color = Color.Green
                                        pathEffect = PathEffect.cornerPathEffect(rect.maxDimension / 3)
                                    }
                                )
                            }
                        }

                    }
                }
            )
        }
    }
}
