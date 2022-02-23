package com.dev.jocey.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToFavorite(character: EntityDB)

    @Query("SELECT * FROM swcharacters WHERE name == :name")
    suspend fun getCharacter(name: String): EntityDB?

    @Query("DELETE  FROM swcharacters WHERE name = :name")
    suspend fun deleteByName(name: String)

    @Query("SELECT * FROM swcharacters")
    suspend fun getAllFavorites(): List<EntityDB>
}