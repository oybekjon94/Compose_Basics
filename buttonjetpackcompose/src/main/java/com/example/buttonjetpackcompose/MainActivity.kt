package com.example.buttonjetpackcompose

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttonjetpackcompose.ui.theme.Compose_BasicsTheme

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
    Column(
        Modifier.padding(10.dp)
    ) {
        SimpleButton()
        ButtonWithColor()
        ButtonWithTwoTextView()
        ButtonWithIcon()
        ButtonWithRectangleShape()
        ButtonWithCutCornerShape()
        ButtonWithBorder()
        ButtonWithElevation()
    }

}

@Composable
fun SimpleButton(){
    Button(onClick = {
        
    }) {
        Text(text = "Simple Button")
    }
}
@Composable
fun ButtonWithColor(){
    Button(onClick = {
        //your onclick code
    },
    colors = ButtonDefaults.buttonColors(
    Color.DarkGray)) {
        Text(text = "Button with gray background",
        color = Color.White
        )
    }
}
@Composable
fun ButtonWithTwoTextView(){
    Button(onClick = {
        //your onClick code here
    }) {
       Text(text = "Click", color = Color.Magenta)
       Text(text = "Here", color = Color.Green)
    }
}
//Button With Icon
@Composable
fun ButtonWithIcon(){
    Button(onClick = {}){
        Image(
            painterResource(id = R.drawable.img),
            contentDescription = "Cart Button Icon",
            modifier = Modifier.size(20.dp)
        )
        Text(text = "Add to cart",Modifier.padding(start = 10.dp))
    }
}

@Composable
fun ButtonWithRectangleShape(){
    Button(onClick = { /*TODO*/ },
    shape = RoundedCornerShape(20.dp)
    ) {
        Text(text = "Rectangle shape")
    }
}
@Composable
fun ButtonWithCutCornerShape(){
    //here we use Int,so it will take percentage
    Button(onClick = { /*TODO*/ },
    shape = CutCornerShape(10)
    ) {
        Text(text = "Cut corner shape")
    }

}
@Composable
fun ButtonWithBorder(){
    Button(onClick = { /*TODO*/ },
    border = BorderStroke(1.dp,Color.Red),
        colors = ButtonDefaults.outlinedButtonColors(contentColor =
        Color.Red
        )
    ) {
        Text(text = "Button with border",
        color = Color.DarkGray
        )
    }
}
    @Composable
    fun ButtonWithElevation(){
        Button(onClick = { /*TODO*/ },
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 10.dp,
            disabledElevation = 10.dp
        )) {
            Text(text = "Button with elevation")

        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_BasicsTheme {
        MainScreen()
    }
}