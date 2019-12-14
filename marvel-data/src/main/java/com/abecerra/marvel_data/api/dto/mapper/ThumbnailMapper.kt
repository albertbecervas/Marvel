package com.abecerra.marvel_data.api.dto.mapper

import com.abecerra.marvel_data.api.dto.ThumbnailDto

object ThumbnailMapper {

    private const val DOT: String = "."

    fun map(thumbnail: ThumbnailDto): String {
        return thumbnail.path + DOT + thumbnail.extension
    }
}