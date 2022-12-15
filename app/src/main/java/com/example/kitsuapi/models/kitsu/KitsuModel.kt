package com.example.kitsuapi.models.kitsu

import com.example.kitsuapi.base.IBaseDiffModel
import com.example.kitsuapi.models.Attributes
import com.google.gson.annotations.SerializedName

data class KitsuModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("attributes")
    val attributes: Attributes
): IBaseDiffModel<Int>