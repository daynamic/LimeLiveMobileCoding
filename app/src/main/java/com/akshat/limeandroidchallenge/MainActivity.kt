package com.akshat.limeandroidchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akshat.limeandroidchallenge.navigation.LimeChallengeNavigation
import com.akshat.limeandroidchallenge.ui.theme.LimeAndroidChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LimeChallengeApp()
        }
    }
}

@Composable
fun LimeChallengeApp() {
    LimeAndroidChallengeTheme {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) { _ ->
            LimeChallengeNavigation()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LimeChallengeApp()
}