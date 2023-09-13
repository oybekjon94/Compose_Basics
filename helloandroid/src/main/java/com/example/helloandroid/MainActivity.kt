package com.example.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloandroid.ui.theme.Compose_BasicsTheme

class MainActivity : ComponentActivity() {
    //onCreate runtime systemda activity boshlanganda chaqiriladigan birinchi method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_BasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoScreen()
                }
            }
        }
    }

    @Composable
    fun DemoText(message:String,fontSize:Float){
        Text(
            text = message,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold
            )
    }

    @Composable
    fun DemoSlider(sliderPosition:Float,onPositionChange:(Float) -> Unit){
        Slider(
            modifier = Modifier.padding(10.dp),
            valueRange = 20f..40f,
            value = sliderPosition,
            onValueChange = { onPositionChange(it)}
        )
    }
    @Composable
    fun DemoScreen(){
        var sliderPosition by remember {
            mutableStateOf(20f)
        }
        val handlePositionChange = {position:Float ->
            sliderPosition = position
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            DemoText(message = "Welcome to Compose", fontSize = sliderPosition)

            Spacer(modifier = Modifier.height(150.dp) )

            DemoSlider(sliderPosition = sliderPosition, onPositionChange = handlePositionChange)

            Text(
                style = MaterialTheme.typography.titleLarge,
                text = sliderPosition.toInt().toString() + "sp"
            )

        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun Preview(){
        Compose_BasicsTheme{
            DemoScreen()

        }
    }
}

