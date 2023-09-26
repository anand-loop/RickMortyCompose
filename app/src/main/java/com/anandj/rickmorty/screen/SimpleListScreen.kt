package com.anandj.rickmorty.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anandj.rickmorty.framework.ListViewModel
import com.anandj.rickmorty.framework.ListViewState
import com.anandj.rickmorty.data.Character
import com.anandj.rickmorty.ui.CharacterView

@Composable
fun <T> SimpleStatefulList(
    viewModel: ListViewModel<*>,
    modifier: Modifier = Modifier,
    itemContent: @Composable (T) -> Unit,
) {
    val state = viewModel.state.collectAsState()
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (val viewState = state.value) {
            is ListViewState.Loaded<*> -> {
                SimpleList(viewState.data) {
                    itemContent(it as T)
                }
            }

            is ListViewState.Loading -> {
                CircularProgressIndicator()
            }

            is ListViewState.Error -> {
                Text(text = viewState.ex.message ?: "Unknown Error")
            }
        }
    }
}

@Composable
inline fun <reified T> SimpleList(
    data: List<T>,
    modifier: Modifier = Modifier,
    crossinline itemContent: @Composable (T) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(data) { item ->
            when (item) {
                is T -> {
                    itemContent(item)
                }

                else -> Text(text = item.toString())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleListPreview() {
    val previewCharacters = listOf(
        Character(name = "Yolo Solo"),
        Character(name = "Mr. Test"),
        Character(name = "Bruh McBrah"),
        Character(name = "Mrs. Test")
    )

    SimpleList(previewCharacters, Modifier) {
        CharacterView(it)
    }
}
