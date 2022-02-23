package com.dev.jocey.model.network

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.ArrayList


data class EntityNetwok(
    @SerializedName("name") val name: String?,
    @SerializedName("height") val height: String?,
    @SerializedName("mass") val mass: String?,
    @SerializedName("hair_color") val hair_color: String?,
    @SerializedName("skin_color") val skin_color: String?,
    @SerializedName("eye_color") val eye_color: String?,
    @SerializedName("birth_year") val birth_year: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("homeworld") val homeworld: String?,
    @SerializedName("films") val films: ArrayList<String>?,
    @SerializedName("species") val species: ArrayList<String>?,
    @SerializedName("vehicles") val vehicles: ArrayList<String>?,
    @SerializedName("starships") val starships: ArrayList<String>?,
    @SerializedName("created") val created: String?,
    @SerializedName("edited") val edited: String?,
    @SerializedName("url") val url: String?
)

