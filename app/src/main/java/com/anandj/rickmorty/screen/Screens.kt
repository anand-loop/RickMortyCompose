package com.anandj.rickmorty.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anandj.rickmorty.data.Episode
import com.anandj.rickmorty.data.Location
import com.anandj.rickmorty.ui.EpisodeView
import com.anandj.rickmorty.ui.LocationView

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
