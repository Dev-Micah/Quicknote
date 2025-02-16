package com.micahnyabuto.note.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.micahnyabuto.note.ui.screens.EntryScreen
import com.micahnyabuto.note.ui.screens.HomeScreen

@Composable
fun NoteApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){

        composable("home") { HomeScreen(navController) }

        composable("entry"){ EntryScreen(navigateBack = {navController.navigateUp()}, onNavigateUp = {navController.navigateUp()})}}
    }



