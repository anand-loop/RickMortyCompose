package com.anandj.rickmorty.viewmodel

import com.anandj.rickmorty.data.Episode
import com.anandj.rickmorty.framework.PagingViewModel
import com.anandj.rickmorty.paging.EpisodesPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val pagingSource: EpisodesPagingSource
) : PagingViewModel<Int, Episode, EpisodesPagingSource>(
    { pagingSource }
)
