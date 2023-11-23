package com.anandj.rickmorty.screen.episodes

import com.anandj.rickmorty.framework.PagingViewModel
import com.anandj.rickmorty.network.data.Episode
import com.anandj.rickmorty.screen.episodes.EpisodesPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val pagingSource: EpisodesPagingSource
) : PagingViewModel<Int, Episode, EpisodesPagingSource>(
    { pagingSource }
)
