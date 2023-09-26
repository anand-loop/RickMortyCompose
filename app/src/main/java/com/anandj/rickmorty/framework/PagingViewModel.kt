package com.anandj.rickmorty.framework

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource

abstract class PagingViewModel<T : Any, PagerSourceT : PagingSource<Int, T>, StateT, in ActionT> constructor(
    initialState: StateT,
    pagingSourceFactory: () -> PagerSourceT,
) : BaseViewModel<StateT, ActionT>(initialState) {
    private val PAGE_SIZE = 10

    val pager = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE),
        pagingSourceFactory = pagingSourceFactory
    ).flow
}
