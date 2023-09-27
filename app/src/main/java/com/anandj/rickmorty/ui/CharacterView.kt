package com.anandj.rickmorty.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.anandj.rickmorty.R
import com.anandj.rickmorty.data.Character
import com.anandj.rickmorty.data.Status
import com.anandj.rickmorty.theme.Dimen

@Composable
fun CharacterView(character: Character, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (image, name, species, status) = createRefs()

            AsyncImage(
                model = character.image,
                placeholder = painterResource(R.drawable.image_placeholder),
                contentDescription = character.name,
                modifier = Modifier
                    .size(Dimen.ProfileImage)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                    }
            )

            Text(
                text = character.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.constrainAs(name) {
                    start.linkTo(image.end, margin = Dimen.ContentPadding)
                    top.linkTo(parent.top, margin = Dimen.ContentPadding)
                    end.linkTo(parent.end, margin = Dimen.ContentPadding)
                    width = Dimension.fillToConstraints
                }
            )

            Text(
                text = character.species,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.constrainAs(species) {
                    start.linkTo(image.end, margin = Dimen.ContentPadding)
                    top.linkTo(name.bottom)
                    end.linkTo(parent.end, margin = Dimen.ContentPadding)
                    width = Dimension.fillToConstraints
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
                        bottom.linkTo(parent.bottom, margin = Dimen.ContentPadding)
                        end.linkTo(parent.end, margin = Dimen.ContentPadding)
                    },
                    tint = Color.Red,
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
        character = Character(
            name = "ReallyLongFirstName ReallyLongLastName",
            status = Status.UNKNOWN,
            species = "Human",
            image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg"
        )
    )
}
