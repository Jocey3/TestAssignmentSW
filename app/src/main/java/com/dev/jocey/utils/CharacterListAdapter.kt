package com.dev.jocey.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.jocey.databinding.ItemRvBinding
import com.dev.jocey.utils.CharacterListAdapter.VH
import com.dev.jocey.utils.entityes.CharacterPar

class CharacterListAdapter(
    private val list: List<CharacterPar>,
    private val favoritesClick: FavoritesClick,
    private val detailClick: DetailClick
) : RecyclerView.Adapter<VH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position], favoritesClick, detailClick)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class VH(
        private val binding: ItemRvBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            characterEntity: CharacterPar,
            favoritesClick: FavoritesClick,
            detailClick: DetailClick
        ) {
            binding.tvName.text = characterEntity.name
            binding.cardItem.setOnClickListener { detailClick.clickOnCharacter(characterEntity) }
            binding.tbFavorite.setOnClickListener {
                favoritesClick.clickOnFavorite(it)
            }
        }
    }
}