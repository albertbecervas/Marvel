package com.abecerra.marvel_data.api.dto

data class ResponseDataDto<T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: T
)