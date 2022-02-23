package com.dev.jocey.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.jocey.databinding.ItemFilmsBinding

class FilmsAdapter(
    private val list: List<String>
) : RecyclerView.Adapter<FilmsAdapter.VHFilms>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHFilms {
        return VHFilms(ItemFilmsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: VHFilms, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class VHFilms(
        private val binding: ItemFilmsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            film: String
        ) {
            binding.tvFilm.text = film
        }
    }
}
