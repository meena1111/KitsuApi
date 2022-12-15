package com.example.kitsuapi.models.kitsu

import com.example.kitsuapi.models.Links
import com.example.kitsuapi.models.Meta
import com.google.gson.annotations.SerializedName

data class KitsuResponse(
    @SerializedName("data")
    val result: List<KitsuModel>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("links")
    val links: Links
)