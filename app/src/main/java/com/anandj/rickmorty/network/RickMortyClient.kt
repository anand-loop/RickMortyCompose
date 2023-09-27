package com.anandj.rickmorty.network

import com.anandj.rickmorty.network.data.Character
import com.anandj.rickmorty.network.data.Episode
import com.anandj.rickmorty.network.data.Location
import com.anandj.rickmorty.network.data.PaginatedResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RickMortyClient @Inject constructor(
    private val api: RickMortyApi
) {

    suspend fun getCharacters(page: Int = 1): Result<PaginatedResult<Character>> {
        return try {
            Result.success(api.getCharacters(page = page))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getLocations(page: Int = 1): Result<PaginatedResult<Location>> {
        return try {
            Result.success(api.getLocations(page = page))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getEpisodes(page: Int = 1): Result<PaginatedResult<Episode>> {
        return try {
            Result.success(api.getEpisode(page = page))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
