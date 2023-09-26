package com.anandj.rickmorty.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.anandj.rickmorty.data.Character
import com.anandj.rickmorty.data.Episode
import com.anandj.rickmorty.data.Location
import com.anandj.rickmorty.ui.CharacterView
import com.anandj.rickmorty.ui.EpisodeView
import com.anandj.rickmorty.ui.LocationView

@Composable
fun CharactersScreen() {
    val viewModel: CharactersViewModel = viewModel()
    val characters: LazyPagingItems<Character> = viewModel.pager.collectAsLazyPagingItems()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (characters.loadState.refresh) {
            is LoadState.Loading -> {
                CircularProgressIndicator()
            }

            is LoadState.Error -> {
                Text(text = "Unknown Error")
            }

            else -> {
                LazyColumn {
                    items(
                        count = characters.itemCount,
                        key = characters.itemKey { it.hashCode() },
                        contentType = characters.itemContentType { "characterType" }
                    ) { index ->
                        characters[index]?.let {
                            CharacterView(character = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LocationsScreen() {
    val viewModel: LocationsViewModel = viewModel()
    SimpleStatefulList<Location>(viewModel) {
        LocationView(location = it)
    }
}

@Composable
fun EpisodesScreen() {
    val viewModel: EpisodesViewModel = viewModel()
    SimpleStatefulList<Episode>(viewModel) {
        EpisodeView(episode = it)
    }
}
