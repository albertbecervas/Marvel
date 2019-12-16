package com.abecerra.marvel_data.api.dto

import com.google.gson.annotations.SerializedName

data class CharacterSectionDto(
    @SerializedName("items") val items: List<SectionDto>
)

data class SectionDto(
    @SerializedName("name") val name: String,
    @SerializedName("resourceURI") val resourceUri: String
)
