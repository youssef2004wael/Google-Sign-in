package com.trainining.googlesigninjp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trainining.googlesigninjp.ui.theme.GoogleSignInJpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoogleSignInJpTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen (modifier: Modifier = Modifier){
   
Column(modifier = modifier
    .fillMaxSize()
    .padding(top = 64.dp, end = 32.dp, start = 32.dp)) {
    Image(
        painter = painterResource(R.drawable.google_icon)
        ,  contentDescription = "Google Logo" ,
        modifier = modifier
            .size(size = 50.dp)
    )
    Text(
        text = "Sign in"
        , fontSize = 40.sp
        , fontFamily = FontFamily(Font(R.font.google_font))
        ,  modifier = modifier
            .padding(top = 16.dp)

    )
    Text(
        text = "Use your Google Account",
        modifier = modifier
            .padding(top = 16.dp)
    )
    EmailTextFeild()
    Text(text="Forgot email?"
    , color = Color.Blue
    , fontWeight = FontWeight.SemiBold
        ,
        modifier = modifier
            .padding(top = 8.dp)
    )
    Text(
        text = buildAnnotatedString {
            append ("Not your computer? Use private Browsing windows to sign in.")
            withStyle(style = SpanStyle(color = Color.Blue , fontWeight = FontWeight.SemiBold )){
                append("Learn more about using Guest mode")
            }
        } , modifier = modifier
            .padding(top = 32.dp)
    )
    Row(modifier = modifier
        .padding(top = 32.dp)
        .fillMaxWidth()
        , horizontalArrangement = Arrangement.SpaceBetween
        , verticalAlignment = Alignment.CenterVertically
        ) {
        Text(text = "Create Account" , color = Color.Blue)
        Button(onClick = {} , colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
            Text(text = "Next")
        }

    }
}
}

@Composable
 fun EmailTextFeild(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    val brush = Brush.linearGradient(colors = listOf(Color.Red , Color.Green , Color.Blue))
    OutlinedTextField(
        modifier = modifier
            .padding(top = 32.dp)
            .fillMaxWidth(),
        value = email,
        onValueChange = {
            email = it
        }
            ,

        textStyle = TextStyle(brush = brush)

        ,


        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        ,

        label = {
            Image(
                painter = painterResource(R.drawable.google_icon)
                ,  contentDescription = "Google Logo" ,
                modifier = modifier
                    .size(size = 20.dp)
            )
             Text(
            text = "Email or Phone" , Modifier.padding(start = 32.dp)
        ) }
    )
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview(){
LoginScreen()
}

