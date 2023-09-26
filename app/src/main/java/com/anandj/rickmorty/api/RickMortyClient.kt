package com.anandj.rickmorty.api

import com.anandj.rickmorty.data.Character
import com.anandj.rickmorty.data.Episode
import com.anandj.rickmorty.data.Location
import com.anandj.rickmorty.data.PaginatedResult
import com.anandj.rickmorty.data.StatusAdapter
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RickMortyClient {

    companion object {
        private val INSTANCE = RickMortyClient()

        fun getInstance() = INSTANCE
    }

    private constructor()

    private val moshi = Moshi.Builder()
        .add(StatusAdapter())
        .build()

    private val api = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(RickMortyApi::class.java)

    suspend fun getCharacters(page: Int = 1): Result<PaginatedResult<Character>> {
        return try {
            Result.success(api.getCharacters(page = page))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getLocations(): Result<PaginatedResult<Location>> {
        return try {
            Result.success(api.getLocations())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getEpisodes(): Result<PaginatedResult<Episode>> {
        return try {
            Result.success(api.getEpisode())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
