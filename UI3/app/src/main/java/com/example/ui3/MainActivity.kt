package com.example.ui3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAppContainer()
        }
    }
}

@Composable
fun MainAppContainer() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabTitles = listOf("Bài 1", "Bài 2", "Bài 3")

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabTitles.forEachIndexed { index, title ->
                    NavigationBarItem(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        label = { Text(title) },
                        icon = {}
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                0 -> Exercise1Screen()
                1 -> Exercise2Screen()
                2 -> Exercise3Screen()
            }
        }
    }
}