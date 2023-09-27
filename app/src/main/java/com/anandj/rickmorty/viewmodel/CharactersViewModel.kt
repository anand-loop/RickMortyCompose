package com.anandj.rickmorty.viewmodel

import com.anandj.rickmorty.data.Character
import com.anandj.rickmorty.framework.PagingViewModel
import com.anandj.rickmorty.paging.CharactersPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val pagingSource: CharactersPagingSource
) : PagingViewModel<Int, Character, CharactersPagingSource>(
    { pagingSource }
)
