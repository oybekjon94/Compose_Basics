package com.example.textincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.textincompose.ui.theme.Compose_BasicsTheme
import java.time.format.TextStyle

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
                   TextContainer()
                }
            }
        }
    }
}

@Composable
fun TextWithSize(label:String,size:TextUnit){
    Text(label, fontSize = size)
}

@Composable
fun ColorText(){
    Text("Color text", color = Color.Blue)
}

@Composable
fun BoldText(){
    Text("Bold text", fontWeight = FontWeight.Bold)
}

@Composable
fun ItalicText(){
    Text(text = "Italic Text", fontStyle = FontStyle.Italic)
}

@Composable
fun MaxLines(){
    Text(text = "hello".repeat(20), maxLines = 2)
}
 
@Composable
fun OverflowText(){
    Text(text = "hello text".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

@Composable
fun SelectableText(){
    SelectionContainer {
     Text(text = "This text is selectable")
    }
}

@Composable
fun TextContainer(){
    Column {
        TextWithSize(label ="Big text" , size = 40.sp)
        ColorText()
        BoldText()
        ItalicText()
        OverflowText()
        SelectableText()
        MaxLines()
    }
}

val redTextStyle = androidx.compose.ui.text.TextStyle(color = Color.Red, fontSize = 30.sp)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Compose_BasicsTheme {
        TextContainer()
    }
}