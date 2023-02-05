package com.sachin.jobapp

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import com.sachin.jobapp.presentation.screen.HomeScreen
import com.sachin.jobapp.ui.theme.JobAppTheme
import dagger.hilt.android.AndroidEntryPoint
import java.net.SocketException

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Job App",
                                    color = Color.White
                                )
                            },
                        )
                    },
                ) {
                    HomeScreen();
                }
            }
        }
    }
}

