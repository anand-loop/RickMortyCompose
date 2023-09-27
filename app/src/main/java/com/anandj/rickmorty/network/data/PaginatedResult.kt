package com.anandj.rickmorty.network.data

data class PaginatedResult<T>(
    val info: PaginationInfo,
    val results: List<T>
)
