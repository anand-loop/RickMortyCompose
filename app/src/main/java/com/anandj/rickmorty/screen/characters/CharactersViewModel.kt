package com.anandj.rickmorty.screen.characters

import com.anandj.rickmorty.framework.PagingViewModel
import com.anandj.rickmorty.network.data.Character
import com.anandj.rickmorty.screen.characters.CharactersPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val pagingSource: CharactersPagingSource
) : PagingViewModel<Int, Character, CharactersPagingSource>(
    { pagingSource }
)
