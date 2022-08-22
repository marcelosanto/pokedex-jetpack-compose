package com.marcelo.pokemonjetpackcompose.network

import com.marcelo.pokemonjetpackcompose.model.Pokemon
import com.marcelo.pokemonjetpackcompose.model.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface PokeAPI {
    @GET("pokemon")
    suspend fun getAllPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): Pokemon
}