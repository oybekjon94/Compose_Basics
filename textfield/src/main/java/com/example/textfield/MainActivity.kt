@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.textfield.ui.theme.Compose_BasicsTheme

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
                    TextFieldWithIcons()
                }
            }
        }
    }
}

@Composable
fun TextFieldWithIcons(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(value = text, leadingIcon = {
        Icon(imageVector = Icons.Default.Email,
            contentDescription = "emailIcon")
    },
    onValueChange = {text = it},
    label = { Text(text = "Email address")},
    placeholder = { Text(text = "Enter your e-mail")},
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_BasicsTheme {
        TextFieldWithIcons()
    }
}