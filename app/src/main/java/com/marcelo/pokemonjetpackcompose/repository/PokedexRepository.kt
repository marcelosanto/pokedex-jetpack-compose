package com.marcelo.pokemonjetpackcompose.repository

import com.marcelo.pokemonjetpackcompose.data.DataOrException
import com.marcelo.pokemonjetpackcompose.model.Pokemon
import com.marcelo.pokemonjetpackcompose.model.PokemonList
import com.marcelo.pokemonjetpackcompose.network.PokeAPI
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokedexRepository @Inject constructor(private val api: PokeAPI) {
    suspend fun getAllPokemonList(
        limit: Int,
        offset: Int
    ): DataOrException<PokemonList, Boolean, Exception> {
        val response = try {
            api.getAllPokemons(limit, offset)
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