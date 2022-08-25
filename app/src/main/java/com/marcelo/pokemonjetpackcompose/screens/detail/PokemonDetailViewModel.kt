package com.marcelo.pokemonjetpackcompose.screens.detail

import androidx.lifecycle.ViewModel
import com.marcelo.pokemonjetpackcompose.model.Pokemon
import com.marcelo.pokemonjetpackcompose.repository.PokedexRepository
import com.marcelo.pokemonjetpackcompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokedexRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemon(pokemonName)
    }
}