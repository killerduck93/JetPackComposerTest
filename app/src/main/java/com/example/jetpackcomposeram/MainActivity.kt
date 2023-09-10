package com.example.jetpackcomposeram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeram.ui.theme.JetpackcomposerAMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposerAMTheme {
               Column(
                   modifier = Modifier
                       .fillMaxSize()
                       .background(Color.Blue),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.SpaceAround
                   )
               {
                   Row {
                       Greeting(name = "AM is coming.... ",modifier=Modifier
                           .width(200.dp)
                           .height(400.dp)
                           .background(Color.Green), color = Color.Magenta
                       )
                       Greeting(name = "Meph from Downtown",modifier=Modifier
                           .background(Color.White), color = Color.Black)
                   }
                   Greeting(name = "Have Fun", modifier=Modifier
                       .background(Color.Transparent),color = Color.Green)
               }



            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, color: Color) {
    Text(
        text = "$name",
        modifier = modifier ,
        color =  color
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() { // Splith show u preview
    JetpackcomposerAMTheme {

    }
}