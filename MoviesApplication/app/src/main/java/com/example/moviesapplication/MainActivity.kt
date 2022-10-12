package com.example.moviesapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.moviesapplication.common.presentation.navigation.LocalBackPressedDispatcher
import com.example.moviesapplication.common.presentation.navigation.app.AppNavGraph
import com.example.moviesapplication.common.presentation.theme.MoviesApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoviesApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CompositionLocalProvider(LocalBackPressedDispatcher provides this.onBackPressedDispatcher) {
                        val navController = rememberNavController()

                        AppNavGraph(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}