package com.anandj.rickmorty.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.anandj.rickmorty.R
import com.anandj.rickmorty.model.Character
import com.anandj.rickmorty.model.Status

@Composable
fun CharacterView(character: Character, modifier: Modifier = Modifier) {
    Card(
        elevation = 10.dp,
        modifier = modifier
            .fillMaxWidth()
    ) {
        ConstraintLayout() {
            val (image, name, species, status) = createRefs()

            AsyncImage(
                model = character.image,
                placeholder = painterResource(R.drawable.image_placeholder),
                contentDescription = character.name,
                modifier = Modifier
                    .size(128.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                    }
            )

            Text(
                text = character.name,
                modifier = Modifier.constrainAs(name) {
                    start.linkTo(image.end, margin = 10.dp)
                    top.linkTo(parent.top, margin = 10.dp)
                }
            )

            Text(
                text = character.species,
                modifier = Modifier.constrainAs(species) {
                    start.linkTo(image.end, margin = 10.dp)
                    top.linkTo(name.bottom)
                }
            )

            when (character.status) {
                Status.UNKNOWN -> R.drawable.status_unknown
                Status.DEAD -> R.drawable.status_dead
                else -> null
            }?.let {
                Icon(
                    painter = painterResource(id = it),
                    modifier = Modifier.constrainAs(status) {
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                        end.linkTo(parent.end, margin = 10.dp)
                    },
                    contentDescription = null
                )
            }
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
