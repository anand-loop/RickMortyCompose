package com.anandj.rickmorty.data

import com.squareup.moshi.Json

data class Location(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "dimension")
    val dimension: String
)

data class Episode(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "air_date")
    val airDate: String,
    @field:Json(name = "episode")
    val episode: String
)

data class PaginationInfo(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)

data class PaginatedResult<T>(
    val info: PaginationInfo,
    val results: List<T>
)
