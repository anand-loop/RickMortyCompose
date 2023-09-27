package com.anandj.rickmorty.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anandj.rickmorty.data.Episode
import com.anandj.rickmorty.data.Location
import com.anandj.rickmorty.theme.Dimen

@Composable
fun EpisodeView(episode: Episode, modifier: Modifier = Modifier) {
    Card {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(Dimen.ContentPadding)
        ) {
            Text(text = episode.name, style = MaterialTheme.typography.titleMedium)
            Text(text = episode.airDate, style = MaterialTheme.typography.bodyMedium)
            Text(text = episode.episode, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EpisodeViewPreview() {
    LocationView(
        location = Location(id = 1, name = "Earth", type = "Planet", dimension = "C-137")
    )
}
