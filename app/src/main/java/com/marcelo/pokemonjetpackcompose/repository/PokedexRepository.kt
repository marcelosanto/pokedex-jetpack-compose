package com.marcelo.pokemonjetpackcompose.repository

import com.marcelo.pokemonjetpackcompose.data.DataOrException
import com.marcelo.pokemonjetpackcompose.model.Pokemon
import com.marcelo.pokemonjetpackcompose.model.PokemonList
import com.marcelo.pokemonjetpackcompose.network.PokeAPI
import javax.inject.Inject

class PokedexRepository @Inject constructor(private val api: PokeAPI) {
    suspend fun getAllPokemons(): DataOrException<PokemonList, Boolean, Exception> {
        val response = try {
            api.getAllPokemons()
        } catch (e: Exception) {
            return DataOrException(e = e)
        }

        return DataOrException(data = response)
    }

    suspend fun getPokemon(name: String): DataOrException<Pokemon, Boolean, Exception> {
        val response = try {
            api.getPokemon(name)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }

        return DataOrException(data = response)
    }
}