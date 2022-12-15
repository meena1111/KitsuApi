package com.example.kitsuapi.data.remote.apiservices.anime

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(
        @Query("page[limit]") limit: Int = 20,
        @Query("page[offset]") offset: Int = 0
    ): Response<KitsuApiResponse>

    @GET("anime/{id}")
    suspend fun fetchDetailsAnime(
        @Path("id") id: String
    ): Response<KitsuResponse>
}