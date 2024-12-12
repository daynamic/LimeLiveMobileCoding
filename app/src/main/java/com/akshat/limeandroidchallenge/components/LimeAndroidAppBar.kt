package com.akshat.limeandroidchallenge.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LimeAndroidAppBar(
    title: String = "Lime Android Challenge",
    elevation: Dp = 0.dp,
    navController: NavController
){
    Surface(shadowElevation = elevation) {
        TopAppBar(
            title = {
                Text(text = title,
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold,
                        fontSize = 17.sp)
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(red = 72, green = 117, blue = 183)),
        )
    }
}