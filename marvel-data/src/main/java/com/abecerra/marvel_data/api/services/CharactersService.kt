package com.abecerra.marvel_data.api.services

import com.abecerra.marvel_data.api.dto.CharacterDto
import com.abecerra.marvel_data.api.dto.ResponseDto
import com.abecerra.marvel_data.api.utils.ApiParameters.API_KEY
import com.abecerra.marvel_data.api.utils.ApiParameters.CHARACTERS_URL
import com.abecerra.marvel_data.api.utils.ApiParameters.HASH
import com.abecerra.marvel_data.api.utils.ApiParameters.PARAM_API_KEY
import com.abecerra.marvel_data.api.utils.ApiParameters.PARAM_HASH
import com.abecerra.marvel_data.api.utils.ApiParameters.PARAM_OFFSET
import com.abecerra.marvel_data.api.utils.ApiParameters.PARAM_TS
import com.abecerra.marvel_data.api.utils.ApiParameters.TIME_STAMP
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {

    @GET(CHARACTERS_URL)
    fun getCharactersAsync(
        @Query(PARAM_OFFSET) offset: Int,
        @Query(PARAM_TS) ts: String = TIME_STAMP,
        @Query(PARAM_API_KEY) key: String = API_KEY,
        @Query(PARAM_HASH) hash: String = HASH
    ): Deferred<ResponseDto<List<CharacterDto>>>

}