package com.marcelo.pokemonjetpackcompose.screens.main

import androidx.lifecycle.ViewModel
import com.marcelo.pokemonjetpackcompose.data.DataOrException
import com.marcelo.pokemonjetpackcompose.model.Pokemon
import com.marcelo.pokemonjetpackcompose.model.PokemonList
import com.marcelo.pokemonjetpackcompose.repository.PokedexRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PokedexRepository) : ViewModel() {
    suspend fun getAllPokemons(): DataOrException<PokemonList, Boolean, Exception> {
        return repository.getAllPokemonList()
    }

    suspend fun getPokemon(name: String): DataOrException<Pokemon, Boolean, Exception> {
        return repository.getPokemon(name)
    }
}