package com.anandj.rickmorty.framework

import com.anandj.rickmorty.model.PagedResult

abstract class ListViewModel<T : Any> : BaseViewModel<ListViewState, ListViewAction>(
    ListViewState.Loading
) {
    init {
        sendAction(ListViewAction.FetchData)
    }

    override suspend fun onAction(action: ListViewAction) {
        setState(ListViewState.Loading)

        when (action) {
            is ListViewAction.FetchData -> {
                val newState = fetchData().fold(
                    { value -> ListViewState.Loaded(value.results) },
                    { ex -> ListViewState.Error(ex) }
                )
                setState(newState)
            }
        }
    }

    protected abstract suspend fun fetchData(): Result<PagedResult<T>>
}

sealed class ListViewAction {
    object FetchData : ListViewAction()
}

sealed class ListViewState {
    object Loading : ListViewState()
    data class Error(val ex: Throwable) : ListViewState()
    data class Loaded<T : Any>(val data: List<T>) : ListViewState()
}
