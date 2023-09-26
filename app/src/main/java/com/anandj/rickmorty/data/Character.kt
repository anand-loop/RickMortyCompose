package com.anandj.rickmorty.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import com.squareup.moshi.ToJson

data class Character(
    @field:Json(name = "id")
    val id: Int = 0,
    @field:Json(name = "name")
    val name: String = "",
    @field:Json(name = "status")
    val status: Status = Status.UNSPECIFIED,
    @field:Json(name = "species")
    val species: String = "",
    @field:Json(name = "image")
    val image: String = ""
)

enum class Status(val status: String) {
    UNSPECIFIED("Unspecified"),
    UNKNOWN("Unknown"),
    ALIVE("Alive"),
    DEAD("Dead");

    companion object {
        fun fromString(status: String) = values().associateBy(Status::status)[status] ?: UNSPECIFIED
    }
}

class StatusAdapter {
    @ToJson
    fun toJson(status: Status): String = status.status

    @FromJson
    fun fromJson(value: String): Status = Status.fromString(value)
}
