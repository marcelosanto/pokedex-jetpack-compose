package com.marcelo.pokemonjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marcelo.pokemonjetpackcompose.screens.main.MainScreen
import com.marcelo.pokemonjetpackcompose.screens.splash.PokedexSplashScreen

@Composable
fun PokedexNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = PokedexScreens.SplashScreen.name
    ) {
        composable(PokedexScreens.SplashScreen.name) {
            PokedexSplashScreen(navController = navController)
        }

        composable(PokedexScreens.MainScreen.name) {
            MainScreen(navController = navController)
        }
    }

}
