package com.anandj.rickmorty.screen.episodes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.anandj.rickmorty.network.data.Episode
import com.anandj.rickmorty.ui.theme.Dimen.ContentPadding
import com.anandj.rickmorty.ui.EpisodeView

@Composable
fun EpisodesScreen(viewModel: EpisodesViewModel = hiltViewModel()) {
    val episodes: LazyPagingItems<Episode> = viewModel.pager.collectAsLazyPagingItems()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (episodes.loadState.refresh) {
            is LoadState.Loading -> {
                CircularProgressIndicator()
            }

            is LoadState.Error -> {
                Text(text = "Unknown Error")
            }

            else -> {
                LazyColumn {
                    items(
                        count = episodes.itemCount,
                        key = episodes.itemKey { it.id },
                        contentType = episodes.itemContentType { "characterType" }
                    ) { index ->
                        episodes[index]?.let {
                            EpisodeView(episode = it)
                        }
                    }

                    when (episodes.loadState.append) {
                        is LoadState.Error -> {}
                        LoadState.Loading -> {
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(ContentPadding),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    CircularProgressIndicator()
                                }
                            }
                        }

                        is LoadState.NotLoading -> {}
                    }
                }
            }
        }
    }
}
