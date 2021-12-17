package test.cs.composedex.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import test.cs.composedex.network.responses.pokemon.Pokemon
import test.cs.composedex.network.responses.pokemonList.PokemonList

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon

}