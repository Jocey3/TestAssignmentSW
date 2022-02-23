package com.dev.jocey.model.network

import com.google.gson.annotations.SerializedName


data class ApiAnswer(
    @SerializedName("count") val count: String?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<EntityNetwok>?
)
