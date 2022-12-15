package com.example.kitsuapi.models

import com.example.kitsuapi.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class KitsuModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("attributes")
    val attributes: Attributes
): IBaseDiffModel<Int>