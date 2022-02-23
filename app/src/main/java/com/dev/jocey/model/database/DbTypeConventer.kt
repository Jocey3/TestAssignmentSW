package com.dev.jocey.model.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DbTypeConventer {

    @TypeConverter
    fun fromFilms(films: List<String>): String {
        var gson = Gson()
        return gson.toJson(films);

//        return films.map { it }.joinToString(",")
    }

    @TypeConverter
    fun toFilms(data: String): List<String> {
        var gson = Gson()
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, listType)
//        return data.split(",").map { it }.toList()
    }

}