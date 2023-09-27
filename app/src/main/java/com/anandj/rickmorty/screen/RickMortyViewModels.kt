package com.anandj.rickmorty.screen

import com.anandj.rickmorty.api.RickMortyClient
import com.anandj.rickmorty.data.Character
import com.anandj.rickmorty.data.Episode
import com.anandj.rickmorty.data.Location
import com.anandj.rickmorty.framework.PagingViewModel
import com.anandj.rickmorty.paging.CharactersPagingSource
import com.anandj.rickmorty.paging.EpisodesPagingSource
import com.anandj.rickmorty.paging.LocationsPagingSource

private val client: RickMortyClient = RickMortyClient.getInstance()

class CharactersViewModel : PagingViewModel<Int, Character, CharactersPagingSource>(
    { CharactersPagingSource(client) }
)

class LocationsViewModel : PagingViewModel<Int, Location, LocationsPagingSource>(
    { LocationsPagingSource(client) }
)

class EpisodesViewModel : PagingViewModel<Int, Episode, EpisodesPagingSource>(
    { EpisodesPagingSource(client) }
)
