package com.example.boxlayout

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
import com.example.boxlayout.ui.theme.Compose_BasicsTheme

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
    Box(contentAlignment = Alignment.CenterEnd,
    modifier = Modifier.size(400.dp,400.dp)){
        val height = 200.dp
        val width = 200.dp

        TextCell(text = "1",
            Modifier
                .size(width = width, height = height)
                .align(Alignment.TopStart))
        TextCell(text = "2",
            Modifier
                .size(width = width, height = height)
                .align(Alignment.BottomStart))
        TextCell(text = "3",
            Modifier
                .size(width = width, height = height)
                .align(Alignment.CenterEnd))
    }
}

@Composable
fun TextCell(text:String,modifier: Modifier = Modifier,fontSize:Int = 150){
    val cellModifier = Modifier
        .padding(4.dp)
        .border(width = 5.dp, color = Color.Green)

    Text(text = text,cellModifier.then(modifier),
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
        )

    Surface {
        Text(text = text,cellModifier.then(modifier),
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_BasicsTheme {
       MainScreen()
    }
}