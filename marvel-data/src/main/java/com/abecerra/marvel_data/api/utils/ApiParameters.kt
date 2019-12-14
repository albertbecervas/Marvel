package com.abecerra.marvel_data.api.utils

object ApiParameters {

    const val BASE_URL = "http://gateway.marvel.com/"
    private const val API_VERSION = "v1/public"

    // URL
    const val CHARACTERS_URL = "$API_VERSION/characters"

    // PARAMETERS
    const val PARAM_OFFSET = "offset"
    const val PARAM_TS = "ts"
    const val PARAM_API_KEY = "apikey"
    const val PARAM_HASH = "hash"

    //Todo: obfuscate
    const val TIME_STAMP = "5"
    const val API_KEY = "2c547c8303602d72e17c01b0dbe2968e"
    const val HASH = "67f121b5630424e2cf6cf93c78a3600e"

}