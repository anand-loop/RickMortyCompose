package com.anandj.rickmorty.network.data

import com.squareup.moshi.Json

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
