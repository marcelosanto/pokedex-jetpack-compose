package com.marcelo.pokemonjetpackcompose.utils

object Const {
    const val BASE_URL = "https://pokeapi.co/api/v2/"
    const val PAGE_SIZE = 20

    fun imageUrl(id: Int) =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
}