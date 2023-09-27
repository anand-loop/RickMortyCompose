package com.anandj.rickmorty.network.data

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
