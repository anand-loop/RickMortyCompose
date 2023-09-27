package com.anandj.rickmorty.screen

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.anandj.rickmorty.data.Location
import com.anandj.rickmorty.theme.Dimen.ContentPadding
import com.anandj.rickmorty.ui.LocationView
import com.anandj.rickmorty.viewmodel.LocationsViewModel

@Composable
fun LocationsScreen() {
    val viewModel: LocationsViewModel = hiltViewModel()
    val locations: LazyPagingItems<Location> = viewModel.pager.collectAsLazyPagingItems()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (locations.loadState.refresh) {
            is LoadState.Loading -> {
                CircularProgressIndicator()
            }

            is LoadState.Error -> {
                Text(text = "Unknown Error")
            }

            else -> {
                LazyColumn {
                    items(
                        count = locations.itemCount,
                        key = locations.itemKey { it.id },
                        contentType = locations.itemContentType { "characterType" }
                    ) { index ->
                        locations[index]?.let {
                            LocationView(location = it)
                        }
                    }

                    when (locations.loadState.append) {
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
