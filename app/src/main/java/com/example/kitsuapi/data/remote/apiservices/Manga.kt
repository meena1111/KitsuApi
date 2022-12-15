package com.example.kitsuapi.data.remote.apiservices

import com.example.kitsuapi.models.models.MangaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(
        @Query("page[limit]") limit: Int = 20,
        @Query("page[offset]") offset: Int = 0
    ): Response<MangaResponse>
}