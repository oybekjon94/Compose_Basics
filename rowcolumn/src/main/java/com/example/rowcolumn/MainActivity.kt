package com.example.rowcolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rowcolumn.ui.theme.Compose_BasicsTheme

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
    Column {
        Row{
            Column {
                TextCell(text = "1")
                TextCell(text = "2")
                TextCell(text = "3")
            }
            Column {
                TextCell(text = "4")
                TextCell(text = "5")
                TextCell(text = "6")
            }
            Column {
                TextCell(text = "7")
                TextCell(text = "8")
            }
        }
        Row {
           TextCell(text = "9")
           TextCell(text = "10")
           TextCell(text = "11")
        }
    }
}

@Composable
fun TextCell(text:String,modifier:Modifier = Modifier){
    val cellModifier = Modifier
        .padding(4.dp)
        .size(100.dp, 100.dp)
        .border(width = 4.dp, color = Color.Green)

    Text(text = text,
    cellModifier.then(modifier),
    fontSize = 70.sp,
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