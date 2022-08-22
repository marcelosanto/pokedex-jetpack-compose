package com.marcelo.pokemonjetpackcompose.model

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<PokeResult>
)