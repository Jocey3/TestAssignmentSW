package com.dev.jocey.model.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("people/")
    suspend fun search(@Query("search") name: String): Response<ApiAnswer>
}