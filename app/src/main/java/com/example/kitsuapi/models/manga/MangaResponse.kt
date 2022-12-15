package com.example.kitsuapi.models.manga

import com.example.kitsuapi.models.Links
import com.example.kitsuapi.models.Meta
import com.google.gson.annotations.SerializedName

data class MangaResponse(
    @SerializedName("data")
    val result: List<MangaModel>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("links")
    val links: Links
)