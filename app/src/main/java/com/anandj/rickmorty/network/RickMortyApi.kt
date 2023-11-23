package com.anandj.rickmorty.network

import com.anandj.rickmorty.network.data.Character
import com.anandj.rickmorty.network.data.Episode
import com.anandj.rickmorty.network.data.Location
import com.anandj.rickmorty.network.data.PaginatedResult
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApi {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int, @Query("name") name: String?, @Query("status") status: String?): PaginatedResult<Character>

    @GET("location")
    suspend fun getLocations(@Query("page") page: Int): PaginatedResult<Location>

    @GET("episode")
    suspend fun getEpisode(@Query("page") page: Int): PaginatedResult<Episode>
}
