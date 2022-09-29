package com.anandj.rickmorty.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anandj.rickmorty.model.Location

@Composable
fun LocationView(location: Location, modifier: Modifier = Modifier) {
    Card(elevation = 10.dp) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = location.name)
            Text(text = location.type)
            Text(text = location.dimension)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationViewPreview() {
    LocationView(
        location = Location(name = "Earth", type = "Planet", dimension = "C-137")
    )
}
