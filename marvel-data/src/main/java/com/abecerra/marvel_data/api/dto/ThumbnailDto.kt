package com.abecerra.marvel_data.api.dto

import com.google.gson.annotations.SerializedName

data class ThumbnailDto(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)