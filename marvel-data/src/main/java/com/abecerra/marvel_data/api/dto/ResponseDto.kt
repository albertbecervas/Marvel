package com.abecerra.marvel_data.api.dto

data class ResponseDto<T>(
    val code: Int,
    val status: String,
    val data: ResponseDataDto<T>
)



