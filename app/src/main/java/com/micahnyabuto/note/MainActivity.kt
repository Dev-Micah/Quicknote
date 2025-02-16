package com.micahnyabuto.note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.example.compose.QuicknoteTheme
import com.micahnyabuto.note.ui.navigation.NoteApp
import com.micahnyabuto.note.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuicknoteTheme {
            NoteApp()
            }
        }
    }
}

