package com.example.kitsuapi.models.manga

import com.example.kitsuapi.base.IBaseDiffModel
import com.example.kitsuapi.models.Attributes
import com.google.gson.annotations.SerializedName

data class MangaModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("attributes")
    val attributes: Attributes
): IBaseDiffModel<Int>