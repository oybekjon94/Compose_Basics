package com.example.switchon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.switchon.ui.theme.Compose_BasicsTheme

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
                   CustomSwitch()
                }
            }
        }
    }
    @Composable
    fun CustomSwitch(){
        val checked = remember{ mutableStateOf(true) }

        Column {
            Switch(checked = checked.value, onCheckedChange = {checked.value = it} )
            if (checked.value){
                Text(text = "Switch is On")
            }else{
                Text(text = "Switch is Off")
            }
            
        }
    }
    @Preview
    @Composable
    fun SwitchPreview(){
        CustomSwitch()
    }
}
