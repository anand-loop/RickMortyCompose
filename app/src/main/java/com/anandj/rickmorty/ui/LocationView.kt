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
import com.anandj.rickmorty.network.data.Location
import com.anandj.rickmorty.ui.theme.Dimen

@Composable
fun LocationView(location: Location, modifier: Modifier = Modifier) {
    Card {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(Dimen.ContentPadding)
        ) {
            Text(text = location.name, style = MaterialTheme.typography.titleMedium)
            Text(text = location.type, style = MaterialTheme.typography.bodyMedium)
            Text(text = location.dimension, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationViewPreview() {
    LocationView(
        location = Location(id = 1, name = "Earth", type = "Planet", dimension = "C-137")
    )
}
