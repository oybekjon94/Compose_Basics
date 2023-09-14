package com.example.slotapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slotapi.ui.theme.Compose_BasicsTheme

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
                    SlotDemo {
                        ButtonDemo()
                    }
                }
            }
        }
    }
}

@Composable
fun SlotDemo(middleContent: @Composable () -> Unit) {

    Column {
        Text("Top Text")
        middleContent()
        Text("Bottom Text")
    }
}
@Composable
fun ButtonDemo(){
    Button(onClick = {}){
        Text(text = "Click me")
    }
}

@Preview(showBackground = true)
@Composable
fun SlotPreview(){
    SlotDemo {
        ButtonDemo()
    }
}
