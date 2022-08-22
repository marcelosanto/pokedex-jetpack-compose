package com.marcelo.pokemonjetpackcompose.di

import com.marcelo.pokemonjetpackcompose.network.PokeAPI
import com.marcelo.pokemonjetpackcompose.repository.PokedexRepository
import com.marcelo.pokemonjetpackcompose.utils.Const.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    
    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeAPI
    ) = PokedexRepository(api)

    @Provides
    @Singleton
    fun providePokedexApi(): PokeAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeAPI::class.java)
    }
}