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
class SearchViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {
    //    private var _result =
    val result = MutableLiveData<List<CharacterPar>>()


    suspend fun loadCharacters(name: String) {
        viewModelScope.launch {
            result.value = repository.searchCharacters(name)

        }


    }
}