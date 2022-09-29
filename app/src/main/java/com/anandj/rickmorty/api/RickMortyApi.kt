package com.anandj.rickmorty.api

import com.anandj.rickmorty.model.Character
import com.anandj.rickmorty.model.Episode
import com.anandj.rickmorty.model.Location
import com.anandj.rickmorty.model.PagedResult
import retrofit2.http.GET

internal interface RickMortyApi {
    @GET("character")
    suspend fun getCharacters(): PagedResult<Character>

    @GET("location")
    suspend fun getLocations(): PagedResult<Location>

    @GET("episode")
    suspend fun getEpisode(): PagedResult<Episode>
}
