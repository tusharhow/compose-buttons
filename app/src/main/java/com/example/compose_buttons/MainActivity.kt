package com.example.compose_buttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_buttons.ui.theme.Compose_buttonsTheme
import android.content.Context
import android.widget.Toast
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Column(
               modifier =  Modifier.fillMaxSize(),
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Compose_buttonsTheme {

                   MyNormalButton()
                   Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing*6))
                   MyOutlinedButton()
                   Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing*6))
                   MyTextButton()
                   Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing*6))
                   ButtonCornerShape()
               }
           }
        }
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun MyNormalButton() {

    val context = LocalContext.current

    Button(
        onClick = { showToast(context, "Add Button Clicked") },

        modifier = Modifier.height(50.dp).width(130.dp),

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Red,
            contentColor = Color.White
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Icon",
            modifier = Modifier.size(ButtonDefaults.IconSize*1.5f)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("Add",fontSize = 20.sp)
    }
}

@Composable
fun  MyOutlinedButton() {

    val context = LocalContext.current
    OutlinedButton(onClick = { showToast(context, message = "Like Button Clicked") }, modifier = Modifier.height(50.dp).width(130.dp),) {

        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Favourite Icon",
            modifier = Modifier.size(ButtonDefaults.IconSize*1.5f)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like",fontSize = 20.sp)
    }


}

@Composable
fun  MyTextButton(){
    val context = LocalContext.current
    TextButton(onClick = { showToast(context, message = "Text Button Clicked") }) {

        Text("Text Button",fontSize = 20.sp)


    }
}
@Composable
fun ButtonCornerShape() {
val context = LocalContext.current
    Button(onClick = {showToast(context, message = "Corner Shape Button Clicked") }, shape = CutCornerShape(4.dp), modifier = Modifier.height(50.dp).width(250.dp)) {
        Text(text = "Cut corner shape",fontSize = 20.sp)
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_buttonsTheme {
        MyNormalButton()
        MyOutlinedButton()
        MyTextButton()
        ButtonCornerShape()
    }
}