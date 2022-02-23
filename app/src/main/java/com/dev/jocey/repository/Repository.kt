package com.dev.jocey.repository

import android.util.Log
import com.dev.jocey.model.database.DeviceDataBase
import com.dev.jocey.model.network.ApiService
import com.dev.jocey.utils.entityes.CharacterPar
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val server: ApiService,
    private val dataBase: DeviceDataBase
) {

    suspend fun searchCharacters(name: String): List<CharacterPar> {
        val res = server.search(name).body()?.results ?: listOf()
        val characters =
            res.map { it ->
                CharacterPar(
                    it.name.toString(),
                    it.birth_year.toString(), it.gender.toString(), it.films!!, it.url.toString()
                )
            }
        Log.d("myLog", "${res.size}")
        return characters
    }


}