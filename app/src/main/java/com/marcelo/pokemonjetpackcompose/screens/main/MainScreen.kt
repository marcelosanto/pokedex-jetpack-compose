package com.marcelo.pokemonjetpackcompose.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcelo.pokemonjetpackcompose.R
import com.marcelo.pokemonjetpackcompose.data.DataOrException
import com.marcelo.pokemonjetpackcompose.model.PokeResult
import com.marcelo.pokemonjetpackcompose.model.PokemonList
import com.marcelo.pokemonjetpackcompose.navigation.PokedexScreens

@Composable
fun MainScreen(navController: NavHostController, mainViewModel: MainViewModel = hiltViewModel()) {

    val pokedexData = produceState<DataOrException<PokemonList, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = mainViewModel.getAllPokemons()
        //Log.d("TAG", "MainScreen: $value")
    }.value

    //loadPoke(pokedexData, listaDePokemons, mainViewModel).runCatching {  }
    val context = LocalContext.current

    if (pokedexData.loading == true) {
        // Log.d("TAG", "MainScreen: Loading")
        CircularProgressIndicator()
    } else if (pokedexData.data != null) {

        val listaDePokemons = mutableListOf<PokeResult>()

        listaDePokemons.addAll(pokedexData.data!!.results)


        Surface() {
            LazyColumn() {
                items(items = listaDePokemons) { pokemon ->
                    Text(
                        text = pokemon.name,
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                navController.navigate(PokedexScreens.PokemonDetailScreen.name + "/lols" + "/${pokemon.name}")
                            })

                    Image(
                        painter = painterResource(R.drawable.pikachu),
                        contentDescription = "sssss"
                    )
                }
            }


        }
    }


}


//suspend fun loadPoke(
//    pokedexData: DataOrException<Poke, Boolean, Exception>,
//    listaDePokemons: MutableList<List<Unit>>,
//    mainViewModel: MainViewModel
//) {
//    Log.d("TAG", "loadPoke: aqui ")
//    pokedexData.data!!.results.let {
//        listaDePokemons.add(it.map { result ->
//            val id = result.url
//                .replace("https://pokeapi.co/api/v2/pokemon/", "")
//                .replace("/", "").toInt()
//
//            val rest = mainViewModel.getPokemon(name = ).data
//        })
//    }
//}


