package com.marcelo.pokemonjetpackcompose.repository

import com.marcelo.pokemonjetpackcompose.model.Pokemon
import com.marcelo.pokemonjetpackcompose.model.PokemonList
import com.marcelo.pokemonjetpackcompose.network.PokeAPI
import com.marcelo.pokemonjetpackcompose.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokedexRepository @Inject constructor(private val api: PokeAPI) {

    suspend fun getAllPokemonList(
        limit: Int,
        offset: Int
    ): Resource<PokemonList> {
        val response = try {
            api.getAllPokemons(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(e.message)
        }
        return Resource.Success(response)
    }

    suspend fun getPokemon(name: String): Resource<Pokemon> {
        val response = try {
            api.getPokemon(name.lowercase())
        } catch (e: Exception) {
            return Resource.Error(e.message)
        }

        return Resource.Success(response)
    }
}