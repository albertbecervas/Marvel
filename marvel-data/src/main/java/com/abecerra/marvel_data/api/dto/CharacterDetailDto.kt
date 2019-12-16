package com.abecerra.marvel_data.api.dto

import com.google.gson.annotations.SerializedName

data class CharacterDetailDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: ThumbnailDto,
    @SerializedName("comics") val comics: CharacterSectionDto,
    @SerializedName("stories") val stories: CharacterSectionDto,
    @SerializedName("events") val events: CharacterSectionDto,
    @SerializedName("series") val series: CharacterSectionDto
)