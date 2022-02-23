package com.dev.jocey.repository

import android.util.Log
import com.dev.jocey.model.database.DeviceDataBase
import com.dev.jocey.model.database.EntityDB
import com.dev.jocey.model.network.ApiService
import com.dev.jocey.model.network.EntityNetwok
import com.dev.jocey.utils.entityes.CharacterPar
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val server: ApiService,
    private val dataBase: DeviceDataBase
) {

    suspend fun searchCharacters(name: String): List<CharacterPar> {
        val response = server.searchCharacters(name).body()
        val result = mutableListOf<EntityNetwok>()
        response?.results?.forEach {
            result.add(it)
        }
        var next = response?.next
        while (next != null) {
            val step = server.searchOnPage(next).body()
            next = step?.next
            step?.results?.forEach {
                result.add(it)
            }

        }

        return checkForFavorite(result)
    }

    private suspend fun checkForFavorite(list: List<EntityNetwok>): List<CharacterPar> {
        val characters =
            list.map {
                var flag = 0
                if (dataBase.baseDao().getCharacter(it.name.toString()) != null) {
                    flag = 1
                }
                CharacterPar(
                    it.name.toString(),
                    it.birth_year.toString(),
                    it.gender.toString(),
                    it.filmsUrls!!,
                    it.url.toString(), flag
                )
            }
        Log.d("myLog", "${characters.size}")
        return characters
    }

    suspend fun getFilms(list: List<String?>): List<String> {
        val films = list.map {
            server.searchFilm(it).body()?.title ?: ""

        }
        return films
    }

    suspend fun deleteFromDb(name: String) {
        dataBase.baseDao().deleteByName(name)
    }

    suspend fun addToDB(deatail: CharacterPar) {
        dataBase.baseDao().insertToFavorite(
            EntityDB(
                deatail.name,
                deatail.birth_year,
                deatail.gender,
                getFilms(deatail.films),
                deatail.url
            )
        )
    }

    suspend fun getFavorites(): List<CharacterPar> {
        val response = dataBase.baseDao().getAllFavorites()
        return response.map { CharacterPar(it.name, it.birth_year, it.gender, it.films, it.url, 1) }
    }

    suspend fun getFromDb(name: String): CharacterPar {
        val response = dataBase.baseDao().getCharacter(name)!!
        return CharacterPar(
            response.name,
            response.birth_year,
            response.gender,
            response.films,
            response.url, 1
        )
    }


}