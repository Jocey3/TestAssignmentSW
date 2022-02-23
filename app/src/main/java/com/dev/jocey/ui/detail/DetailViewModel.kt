package com.dev.jocey.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.jocey.repository.Repository
import com.dev.jocey.utils.entityes.CharacterPar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    val films = MutableLiveData<List<String>>()
    fun getFilmTitles(list: List<String?>) {
        viewModelScope.launch {
            films.value = repository.getFilms(list)
        }
    }

    fun addToDB(deatail: CharacterPar) {
        viewModelScope.launch {
            repository.addToDB(deatail)
        }
    }

    fun deleteFromDb(name: String) {
        viewModelScope.launch {
            repository.deleteFromDb(name)
        }
    }

    fun updateCharacter(name: String) {

    }

}