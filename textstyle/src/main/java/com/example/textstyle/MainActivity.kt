package com.example.textstyle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.textstyle.ui.theme.Compose_BasicsTheme
import com.example.textstyle.ui.theme.Typography
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
                  TextStyleDecoration()
                }
            }
        }
    }
}

val baseTextStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontFamily = FontFamily.Serif)
val headingTextStyle = androidx.compose.ui.text.TextStyle(
    color = Color.Blue,
    fontFamily = FontFamily.Serif,
    fontWeight = FontWeight.Bold,
    textDecoration = TextDecoration.Underline
)

@Composable
fun TextStyleDecoration(){
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(), verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
       TextStyleSample()
        Text(text = "Basics", style = headingTextStyle)

        BasicsTextStyles()
        Text(text = "Text Decoration Samples", style = headingTextStyle)

        TextDecorationStyle()

        Text(text = "Typography Samples" , style = headingTextStyle)
        TextHeadingStyle()

        Text(text = "Merging two or more text style", style = headingTextStyle)
        TextStyleMerge()
    }
}

@Composable
fun TextStyleSample(){
    Text(text = "Text Style() Samples",
    style = androidx.compose.ui.text.TextStyle(
        color = Color.Magenta, fontSize = 24.sp, fontFamily = FontFamily.Serif,
        fontStyle = FontStyle.Italic,
        textDecoration = TextDecoration.Underline
    ),
    modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(),
    textAlign = TextAlign.Center)
}

@Composable
fun BasicsTextStyles(){
    Column {
        Text(text = "Text with Color",
        style = androidx.compose.ui.text.TextStyle(Color.Red))

        Text(text = "Text with Background Color",
        style = androidx.compose.ui.text.TextStyle(background = Color.Yellow))

        Text(text = "Text with Shadow",
        style = androidx.compose.ui.text.TextStyle(
            shadow = Shadow(
                color = Color.Black,
                offset = Offset(5f,5f),
                blurRadius = 5f
            )
        )
        )

        Text(text = "Text with custom font",
        style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Cursive))

        Text(text = "Text with big font size",
        style = androidx.compose.ui.text.TextStyle(fontSize = 30.sp))
    }
}

@Composable
fun TextDecorationStyle(){
    Column {
        Text(text = "Text with Underline",
        style = androidx.compose.ui.text.TextStyle(
            color = Color.Magenta, fontSize = 24.sp,
            textDecoration = TextDecoration.Underline
        ))

        Text(text = "Text with Strike" ,
        style = androidx.compose.ui.text.TextStyle(
            color = Color.DarkGray, fontSize = 24.sp,
            textDecoration = TextDecoration.LineThrough
        ))
    }
}

@Composable
fun TextStyleMerge(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(10.dp)
    ) {
       Text(text = "Base style", style = baseTextStyle)
        Text(text = "Style with extra bold",
        style = baseTextStyle.plus(
            androidx.compose.ui.text.TextStyle(fontWeight = FontWeight.ExtraBold).plus(
                androidx.compose.ui.text.TextStyle(
                    background = Color.Gray
                )
            )
        ))
        Text(text = "Style with Typography",
        style = baseTextStyle.plus(MaterialTheme.typography.headlineLarge))

        Text(text = "Extending font size",
        style = baseTextStyle.plus(androidx.compose.ui.text.TextStyle(fontSize = 36.sp
        )))
    }
}

@Composable
fun TextHeadingStyle(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
    ) {
        Text(text = "Heading 4",
            style = MaterialTheme.typography.headlineLarge)

       Text(text = "Heading 3",
       style = MaterialTheme.typography.headlineMedium)

        Text(text = "Heading 2",
            style = MaterialTheme.typography.headlineSmall)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_BasicsTheme {
         TextStyleDecoration()
    }
}