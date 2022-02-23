package com.dev.jocey.ui.search.util

import android.view.View
import com.dev.jocey.utils.entityes.CharacterPar

interface FavoritesClick {
    fun clickOnFavorite(view: View, character: CharacterPar)
}