package com.marcelo.pokemonjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.marcelo.pokemonjetpackcompose.screens.detail.PokemonDetailScreen
import com.marcelo.pokemonjetpackcompose.screens.main.PokemonListScreen
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


        composable(PokedexScreens.PokemonListScreen.name) {
            PokemonListScreen(navController = navController)
        }

        composable("${PokedexScreens.PokemonDetailScreen.name}/{dominantColor}/{pokemonName}",
            arguments = listOf(
                navArgument("dominantColor") {
                    type = NavType.IntType
                },
                navArgument("pokemonName") {
                    type = NavType.StringType
                }
            )) {
            val dominantColor = remember {
                val color = it.arguments?.getInt("dominantColor")
                color?.let { Color(it) } ?: Color.White
            }
            val pokemonName = remember {
                it.arguments?.getString("pokemonName")
            }

            PokemonDetailScreen(
                navController = navController,
                dominantColor = dominantColor,
                pokemonName = pokemonName
            )
        }

    }

}
