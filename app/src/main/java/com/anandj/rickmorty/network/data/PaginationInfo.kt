package com.anandj.rickmorty.network.data

data class PaginationInfo(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)
