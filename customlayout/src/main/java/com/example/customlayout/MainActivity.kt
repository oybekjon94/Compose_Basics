package com.example.customlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.customlayout.ui.theme.Compose_BasicsTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_BasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   MainScreen()
                }
            }
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier){
    Box(
        Modifier
            .padding(1.dp)
            .size(width = 50.dp, height = 10.dp)
            .then(modifier)) {
    }
}
@Composable
fun Modifier.exampeLayout(
    fraction:Float
) = layout{
        measurable, constraints ->
    val placeable = measurable.measure(constraints)

    val x = -(placeable.width * fraction).roundToInt()
    layout(placeable.width,placeable.height){
        placeable.placeRelative(x=x, y=0)
    }
}
@Composable
fun MainScreen(){
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.size(120.dp,80.dp)){
            Column {
                ColorBox(
                    Modifier
                        .exampeLayout(0f)
                        .background(Color.Blue)
                )
                ColorBox(
                    Modifier
                        .exampeLayout(0.25f)
                        .background(Color.Green)
                )
                ColorBox(
                    Modifier
                        .exampeLayout(0.5f)
                        .background(Color.Yellow)
                )
                ColorBox(
                    Modifier
                        .exampeLayout(0.25f)
                        .background(Color.Red)
                )
                ColorBox(
                    Modifier
                        .exampeLayout(0.0f)
                        .background(Color.Magenta)
                )
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_BasicsTheme {
      MainScreen()
    }
}