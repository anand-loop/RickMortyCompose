package com.anandj.rickmorty.network

import com.anandj.rickmorty.network.data.Character
import com.anandj.rickmorty.network.data.Episode
import com.anandj.rickmorty.network.data.Location
import com.anandj.rickmorty.network.data.PaginatedResult
import com.anandj.rickmorty.network.data.Status
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RickMortyClient @Inject constructor(
    private val api: RickMortyApi,
) {
    companion object {
        private val TAG = RickMortyClient::class.simpleName
    }

    suspend fun getCharacters(
        page: Int = 1,
        name: String? = null,
        status: Status? = null,
    ): Result<PaginatedResult<Character>> {
        return try {
            Timber.d("getCharacters: page=$page, name=$name, status=$status")
            Result.success(api.getCharacters(page = page, name = name, status = status?.name))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getLocations(page: Int = 1): Result<PaginatedResult<Location>> {
        return try {
            Timber.d("getLocations: page=$page")
            Result.success(api.getLocations(page = page))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getEpisodes(page: Int = 1): Result<PaginatedResult<Episode>> {
        return try {
            Timber.d("getEpisodes: page=$page")
            Result.success(api.getEpisode(page = page))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
