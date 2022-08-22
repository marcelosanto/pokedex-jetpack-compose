package com.marcelo.pokemonjetpackcompose.screens.detail

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun PokemonDetailScreen(
    dominantColor: Color,
    pokemonName: String?,
    navController: NavHostController
) {
    Surface() {
        Text(text = "POKEMON")
    }
}