package com.example.boxscope

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boxscope.ui.theme.Compose_BasicsTheme

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
fun MainScreen(){
    Box(modifier = Modifier.size(height = 200.dp, width = 500.dp)){
        TextCell("Top Start", Modifier.align(Alignment.TopStart))
        TextCell("Top Center", Modifier.align(Alignment.TopCenter))
        TextCell("Top End", Modifier.align(Alignment.TopEnd))

        TextCell("Center Start", Modifier.align(Alignment.CenterStart))
        TextCell("Center", Modifier.align(Alignment.Center))
        TextCell("Center End", Modifier.align(Alignment.CenterEnd))

        TextCell("Bottom Start", Modifier.align(Alignment.BottomStart))
        TextCell("Bottom Center", Modifier.align(Alignment.BottomCenter))
        TextCell("Bottom End", Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun TextCell(text:String,modifier: Modifier = Modifier,fontSize:Int = 20){
    val cellModifier = Modifier
        .padding(4.dp)
        .border(width = 2.dp, color = Color.Green)

    Text(text = text, cellModifier.then(modifier),
    fontSize = fontSize.sp,
    fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_BasicsTheme {
       MainScreen()
    }
}