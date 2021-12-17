package test.cs.composedex.network.repository

import dagger.hilt.android.scopes.ActivityScoped
import test.cs.composedex.network.PokeApi
import test.cs.composedex.network.responses.pokemon.Pokemon
import test.cs.composedex.network.responses.pokemonList.PokemonList
import test.cs.composedex.utils.Resource
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}