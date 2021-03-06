package com.dev.jocey.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.jocey.repository.Repository
import com.dev.jocey.utils.entityes.CharacterPar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: Repository
) :
    ViewModel() {
    val query = MutableLiveData<String>()
    val result = MutableLiveData<List<CharacterPar>>()


    fun searchCharacters(name: String) {
        viewModelScope.launch {
            result.value = repository.searchCharacters(name)
        }

    }


    fun addToFavorite(character: CharacterPar) {
        viewModelScope.launch {
            repository.addToDB(character)
        }
    }

    fun deleteFromFavorite(name: String) {
        viewModelScope.launch {
            repository.deleteFromDb(name)
        }
    }
}
