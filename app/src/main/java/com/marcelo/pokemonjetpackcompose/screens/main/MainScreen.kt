package com.marcelo.pokemonjetpackcompose.screens.main

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    Surface() {
        Text(text = "Pokedex")
    }
}