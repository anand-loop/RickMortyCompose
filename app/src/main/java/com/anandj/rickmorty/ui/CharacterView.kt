package com.anandj.rickmorty.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.anandj.rickmorty.R
import com.anandj.rickmorty.model.Character

@Composable
fun CharacterView(character: Character, modifier: Modifier = Modifier) {
    Card(
        elevation = 10.dp
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = character.image,
                placeholder = painterResource(R.drawable.image_placeholder),
                contentDescription = character.name,
                modifier = Modifier
                    .size(128.dp)
                    .padding(end = 10.dp)
            )
            Text(text = character.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterViewPreview() {
    CharacterView(
        character = Character(name = "First Last")
    )
}
