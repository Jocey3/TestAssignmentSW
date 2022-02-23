package com.dev.jocey.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SWCharacters")
data class EntityDB(
    @PrimaryKey
    val name: String,
    val height: String,
    val mass: String,
    val hair_color: String,
    val skin_color: String,
    val eye_color: String,
    val birth_year: String,
    val gender: String,
    val homeworld: String,
    val films: String,
    val url: String
)
