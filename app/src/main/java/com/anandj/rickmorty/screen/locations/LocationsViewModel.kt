package com.anandj.rickmorty.screen.locations

import com.anandj.rickmorty.framework.PagingViewModel
import com.anandj.rickmorty.network.data.Location
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val pagingSource: LocationsPagingSource
) : PagingViewModel<Int, Location, LocationsPagingSource>(
    { pagingSource }
)
