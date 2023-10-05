package com.example.customlayout02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.customlayout02.ui.theme.Compose_BasicsTheme

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
    Box {
       CascadeLayout(spacing = 20,Modifier.padding(5.dp).background(Color.Black)){
           Box(modifier = Modifier.size(60.dp).background(Color.Blue))
           Box(modifier = Modifier.size(80.dp).background(Color.Red))
           Box(modifier = Modifier.size(90.dp).background(Color.Green))
           Box(modifier = Modifier.size(50.dp).background(Color.Yellow))
           Box(modifier = Modifier.size(70.dp).background(Color.Gray))
       }
    }
}

//Custom  layout
@Composable
fun CascadeLayout(
     spacing:Int = 0,
     modifier: Modifier = Modifier,
     content: @Composable () -> Unit
){
    Layout(
        modifier = modifier,
        content = content
    ){
        //measurable -> barcha child elementlarini oziga oladi
        //constraints -> child elementlariga eng kop xamda eng kam kenglik xamda balandlikni beradi
        measurables, constraints ->
        var indent = 0
        layout(constraints.maxWidth, constraints.maxHeight){
            var yCord = 0
            val placeable = measurables.map { measurable ->
                measurable.measure(constraints)
            }
            placeable.forEach{ placeable ->

                placeable.placeRelative(x = indent,y = yCord)
                indent += placeable.width + spacing
                yCord += placeable.height +  spacing
            }
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