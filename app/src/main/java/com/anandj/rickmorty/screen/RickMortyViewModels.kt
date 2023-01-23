package com.anandj.rickmorty.screen

import com.anandj.rickmorty.api.RickMortyClient
import com.anandj.rickmorty.framework.ListViewModel
import com.anandj.rickmorty.model.Character
import com.anandj.rickmorty.model.Episode
import com.anandj.rickmorty.model.Location
import com.anandj.rickmorty.model.PagedResult

private val client: RickMortyClient = RickMortyClient.getInstance()

class CharactersViewModel : ListViewModel<Character>() {
    override suspend fun fetchData(): Result<PagedResult<Character>> {
        return client.getCharacters()
    }
}

class LocationsViewModel : ListViewModel<Location>() {
    override suspend fun fetchData(): Result<PagedResult<Location>> {
        return client.getLocations()
    }
}

class EpisodesViewModel : ListViewModel<Episode>() {
    override suspend fun fetchData(): Result<PagedResult<Episode>> {
        return client.getEpisodes()
    }
}
