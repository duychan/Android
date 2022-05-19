package com.example.hellojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellojetpack.ui.theme.HelloJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloJetpackTheme {
                // A surface container using the 'background' color from the theme
                val counter = remember{
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "${counter.value}",
                            style = TextStyle(color = Color.Black,
                                            fontSize = 35.sp,
                                            fontWeight = FontWeight.ExtraBold))
                        Spacer(modifier = Modifier.height(50.dp))
                        CreateCircle(counter = counter.value){
                            newVal -> counter.value = newVal
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CreateCircle(counter : Int = 0, countUp: (Int) -> Unit){
    Card(modifier = Modifier
                    .size(105.dp)
                    .padding(5.dp)
                    .clickable { countUp(counter + 1) },
        shape = CircleShape,
        elevation = 5.dp,
        backgroundColor = Color.Red){
        Box(contentAlignment = Alignment.Center){
            Text(text= "Tap")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloJetpackTheme {
        Greeting("Android")
    }
}