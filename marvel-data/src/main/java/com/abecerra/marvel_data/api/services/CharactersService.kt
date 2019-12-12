package com.abecerra.marvel_data.api.services

import com.abecerra.marvel_data.ApiConstants
import com.abecerra.marvel_data.api.dto.CharacterDto
import com.abecerra.marvel_data.api.dto.ResponseDataDto
import com.abecerra.marvel_data.api.dto.ResponseDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {
    @GET("V1/public/characters")
    fun getCharactersAsync(
        @Query("ts") ts: String = ApiConstants.TIME_STAMP,
        @Query("apikey") key: String = ApiConstants.API_KEY,
        @Query("hash") hash: String = ApiConstants.HASH
    ): ResponseDto<List<CharacterDto>>
}