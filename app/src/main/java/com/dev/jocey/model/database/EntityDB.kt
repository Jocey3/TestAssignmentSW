package com.dev.jocey.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "SWCharacters")
data class EntityDB(
    @PrimaryKey
    val name: String,
    val birth_year: String,
    val gender: String,
    @TypeConverters(DbTypeConventer::class)
    val films: List<String?>,
    val url: String
)
