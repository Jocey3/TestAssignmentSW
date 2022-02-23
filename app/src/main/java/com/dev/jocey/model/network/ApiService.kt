package com.dev.jocey.model.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET("people/")
    suspend fun searchCharacters(@Query("search") name: String): Response<ApiAnswer>

    @GET
    suspend fun searchOnPage(@Url url: String): Response<ApiAnswer>

    @GET
    suspend fun searchFilm(@Url url: String?): Response<EntityFilm>

    @GET
    suspend fun getCharacter(@Url url: String): Response<EntityNetwok>
}