package com.anandj.rickmorty.screen

import com.anandj.rickmorty.api.RickMortyClient
import com.anandj.rickmorty.data.Character
import com.anandj.rickmorty.data.Episode
import com.anandj.rickmorty.data.Location
import com.anandj.rickmorty.data.PaginatedResult
import com.anandj.rickmorty.framework.ListViewModel
import com.anandj.rickmorty.framework.PagingViewModel
import com.anandj.rickmorty.paging.CharactersPagingSource

private val client: RickMortyClient = RickMortyClient.getInstance()

class CharactersViewModel : PagingViewModel<Int, Character, CharactersPagingSource>(
    { CharactersPagingSource(client) }
)

class LocationsViewModel : ListViewModel<Location>() {
    override suspend fun fetchData(): Result<PaginatedResult<Location>> {
        return client.getLocations()
    }
}

class EpisodesViewModel : ListViewModel<Episode>() {
    override suspend fun fetchData(): Result<PaginatedResult<Episode>> {
        return client.getEpisodes()
    }
}
