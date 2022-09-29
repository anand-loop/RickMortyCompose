package com.anandj.rickmorty.api

import com.anandj.rickmorty.model.Character
import com.anandj.rickmorty.model.Episode
import com.anandj.rickmorty.model.Location
import com.anandj.rickmorty.model.PagedResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RickMortyClient {
    private val api = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(RickMortyApi::class.java)

    suspend fun getCharacters(): Result<PagedResult<Character>> {
        return try {
            Result.success(api.getCharacters())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getLocations(): Result<PagedResult<Location>> {
        return try {
            Result.success(api.getLocations())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getEpisodes(): Result<PagedResult<Episode>> {
        return try {
            Result.success(api.getEpisode())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
