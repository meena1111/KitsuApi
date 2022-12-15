package com.example.kitsuapi.data.repositories

import com.example.kitsuapi.base.BaseRepository
import com.example.kitsuapi.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository
@Inject constructor(private val service: MangaApiService) : BaseRepository() {

    fun fetchManga(limit: Int, offset: Int) = doRequest {
        service.fetchManga(limit, offset)
    }
}