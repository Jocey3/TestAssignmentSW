package com.dev.jocey.ui.search.util

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.dev.jocey.R
import com.dev.jocey.databinding.ItemCharactersBinding
import com.dev.jocey.ui.search.util.SearchAdapter.VHCharacters
import com.dev.jocey.utils.entityes.CharacterPar

class SearchAdapter(
    private val list: List<CharacterPar>,
    private val favoritesClick: FavoritesClick,
    private val detailClick: DetailClick
) : RecyclerView.Adapter<VHCharacters>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHCharacters {
        return VHCharacters(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: VHCharacters, position: Int) {
        holder.bind(list[position], favoritesClick, detailClick)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class VHCharacters(
        private val binding: ItemCharactersBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            val layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            layoutParams.setMargins(
                binding.root.context.resources.getDimension(R.dimen.default_pading).toInt()
            )
            binding.root.layoutParams = layoutParams
        }

        fun bind(
            character: CharacterPar,
            favoritesClick: FavoritesClick,
            detailClick: DetailClick
        ) {
            if (character.favorite == 1) binding.tbFavorite.setBackgroundResource(R.drawable.pic_favorite)
            else binding.tbFavorite.setBackgroundResource(R.drawable.pic_favorite_empthy)
            binding.tvName.text = character.name
            binding.cardItem.setOnClickListener { detailClick.clickOnCharacter(character) }
            binding.tbFavorite.setOnClickListener {
                favoritesClick.clickOnFavorite(it,character)
            }
        }
    }
}