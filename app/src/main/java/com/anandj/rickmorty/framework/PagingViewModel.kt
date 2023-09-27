package com.anandj.rickmorty.framework

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource

abstract class PagingViewModel<Key : Any, Value : Any, PagerSourceT : PagingSource<Key, Value>> constructor(
    pagingSourceFactory: () -> PagerSourceT
) : ViewModel() {
    companion object {
        private const val PAGE_SIZE = 10
    }

    val pager = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE),
        pagingSourceFactory = pagingSourceFactory
    ).flow
}
