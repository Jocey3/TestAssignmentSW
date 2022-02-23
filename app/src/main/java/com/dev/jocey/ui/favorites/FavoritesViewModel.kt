package com.dev.jocey.ui.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.jocey.repository.Repository
import com.dev.jocey.utils.entityes.CharacterPar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val result = MutableLiveData<List<CharacterPar>>()
    fun getAllFavorites() {
        viewModelScope.launch {
            result.value = repository.getFavorites()
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