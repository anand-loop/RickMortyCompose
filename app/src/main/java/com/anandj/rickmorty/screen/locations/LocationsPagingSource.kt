package com.anandj.rickmorty.screen.locations

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.anandj.rickmorty.network.RickMortyClient
import com.anandj.rickmorty.network.data.Location
import java.io.IOException
import javax.inject.Inject

class LocationsPagingSource @Inject constructor(
    private val client: RickMortyClient
) : PagingSource<Int, Location>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Location> {
        return try {
            val page = params.key ?: 1
            val result = client.getLocations(page).getOrThrow()

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = if (result.info.next != null) page + 1 else null

            LoadResult.Page(data = result.results, prevKey = prevKey, nextKey = nextKey)
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Location>): Int? {
        return ((state.anchorPosition ?: 0) - state.config.initialLoadSize / 2).coerceAtLeast(0)
    }
}
