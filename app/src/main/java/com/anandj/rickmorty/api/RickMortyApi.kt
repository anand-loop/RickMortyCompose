package com.anandj.rickmorty.api

import com.anandj.rickmorty.data.Character
import com.anandj.rickmorty.data.Episode
import com.anandj.rickmorty.data.Location
import com.anandj.rickmorty.data.PaginatedResult
import retrofit2.http.GET
import retrofit2.http.Query

internal interface RickMortyApi {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): PaginatedResult<Character>

    @GET("location")
    suspend fun getLocations(): PaginatedResult<Location>

    @GET("episode")
    suspend fun getEpisode(): PaginatedResult<Episode>
}
