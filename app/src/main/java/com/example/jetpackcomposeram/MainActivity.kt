package com.example.jetpackcomposeram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeram.ui.theme.JetpackcomposerAMTheme
import kotlinx.coroutines.launch
import java.util.Random
import kotlin.ranges.random


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposerAMTheme {
               Column( // Modifier is "adding" spec sequencially
                   modifier = Modifier
                       .fillMaxSize()
                       // .padding(30.dp,45.dp,50.dp) // offset from boundaries
                       .background(Color.Blue)
                       .border(2.dp, Color.Red),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.SpaceAround
                   )
               {
                   Row {
                       Greeting(name = "    AM is coming....   ",modifier= Modifier
                           .border(2.dp, Color.White)
                           .width(200.dp)
                           .height(400.dp)
                           .background(Color.Green), color = Color.Magenta
                       )
                       Greeting(name = " Meph from Downtown ",modifier= Modifier
                           .offset(5.dp, 100.dp)
                           .background(Color.White)
                           .border(2.dp, Color.Cyan)
                           , color = Color.Black


                       )
                   }
                   Spacer(modifier = Modifier.height(50.dp))
                   Greeting(name = " Have Fun ", modifier= Modifier
                       .background(Color.Transparent)
                       .border(4.dp, Color.Gray)
                       .padding(30.dp, 30.dp)
                       .background(Color.Gray)
                       .border(2.dp, Color.Gray)
                       .clickable { true }  // usefull for buttons
                       ,color = Color.Green)
                   // next video https://www.youtube.com/watch?v=XCuC_p3E0qo&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=4
               }

            }
            val painter = painterResource(id = R.drawable.pedometer_deluxe)
            val descriptor = "Pedometer first app"
            val title = " Pedometer "

            Box(modifier = Modifier
                .fillMaxSize(0.5f)
                .offset(40.dp, 70.dp)
                .padding(30.dp))
            {
               ImageCard(painter = painter, contentDescription = descriptor, title = title)
            }
            // next video https://www.youtube.com/watch?v=nm_LNJWHi9A&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=5
            // no capital , underscore ok
            val fontFamily = FontFamily(
               Font(R.font.lexend_bold,FontWeight.Bold),
               Font(R.font.lexend_extrabold,FontWeight.ExtraBold),
               Font(R.font.lexend_light,FontWeight.Light),
               Font(R.font.lexend_extralight,FontWeight.ExtraLight),
               Font(R.font.lexend_medium,FontWeight.Medium),
               Font(R.font.lexend_thin,FontWeight.Thin),
               Font(R.font.lexend_regular,FontWeight.Normal),
               Font(R.font.lexend_semibold,FontWeight.SemiBold),
               Font(R.font.lexend_black,FontWeight.Black),
            )
             Box(modifier = Modifier
                 .height(100.dp)
                 .width(225.dp)
                 .offset(100.dp, 500.dp)
                 .background(Color(0xFF101010))
             )
             {
                 Text(
                     text  = buildAnnotatedString {
                          withStyle(
                              style = SpanStyle(
                                  color = Color.Gray,
                                  fontSize = 45.sp,
                              )
                          ){
                              append("Ginger")  // has style declered above
                          }
                         append("Ale") // has style declered below
                     },
                     color = Color.Green,
                     fontSize = 40.sp,
                     fontFamily = fontFamily,
                     fontWeight = FontWeight.SemiBold,
                     fontStyle = FontStyle.Italic,
                     textAlign = TextAlign.Center,
                     textDecoration = TextDecoration.Underline

                 )
             }
          // next https://www.youtube.com/watch?v=s3m1PSd7VWc&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=6
          // State for dynamic view and user UI : Recompising
            ColorBox(
                Modifier
                    .fillMaxSize(0.4f)
                    .offset(220.dp, 200.dp)
                    .padding(20.dp, 20.dp),
                descriptionBox = "ClickME"
            )

         // next https://www.youtube.com/watch?v=_yON9d9if6g&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=7
        // Snackbar
            Snackbar { // for full control of location and timing to be shown
                Text(text = "Daje")
            }
            // For a simple normal Snackbar use Scaffold


            // For a simple normal Snackbar use Scaffold
            val snackBarHostState = remember{SnackbarHostState()}
            var textFieldState by remember{ mutableStateOf("") }
            val scope = rememberCoroutineScope()
            Scaffold (
                modifier = Modifier
                    .fillMaxSize(),
                snackbarHost = {SnackbarHost(hostState = snackBarHostState)}
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(
                        value = textFieldState,
                        label = {
                            Text("Enter your name")
                        },
                        onValueChange = {
                            textFieldState = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            scope.launch {
                                snackBarHostState.showSnackbar("Hello $textFieldState")
                            }
                        }
                    ){
                        Text("Click Me")
                    }
                }

            }
//end
        }
    }
}






// functions
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
@Composable
fun ImageCard(painter:Painter,   contentDescription : String, title: String, modifier: Modifier = Modifier)
{
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(modifier = Modifier.height(200.dp))
        {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f // depends on layout
                    )
                ))
            Box(modifier = Modifier
                .fillMaxSize(0.6f)
                .padding(0.dp, 0.dp),
                contentAlignment = Alignment.BottomStart)
            {
               Text(
                   title,
                   style = TextStyle(color = Color.Magenta, fontSize = 20.sp)

               )    }
        }        
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier, descriptionBox: String)
{
    val color = remember {
        mutableStateOf(Color.Yellow)  // in order to not reset when composable is recalled
    }  // remember from last composition

    Box(modifier = modifier
        .background(color.value)
        .clickable {
            color.value = Color(
                kotlin.random.Random.nextFloat(),
                kotlin.random.Random.nextFloat(),
                kotlin.random.Random.nextFloat(),
                1f
            )
        } ,

    )
    Text(descriptionBox, modifier = modifier, style = TextStyle(color = Color.Magenta, fontSize = 20.sp) // added modifier in order to sync box and label
    )

}