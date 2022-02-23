package com.dev.jocey.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.jocey.R
import com.dev.jocey.databinding.FragmentFavoritesBinding
import com.dev.jocey.ui.BaseFragment
import com.dev.jocey.ui.search.util.DetailClick
import com.dev.jocey.ui.search.util.FavoritesClick
import com.dev.jocey.ui.search.util.SearchAdapter
import com.dev.jocey.utils.entityes.CharacterPar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {
    private val viewModel: FavoritesViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCharacters()
        binding.listFav.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        viewModel.result.observe(
            viewLifecycleOwner
        ) {
            binding.listFav.adapter = SearchAdapter(it, object : FavoritesClick {
                override fun clickOnFavorite(view: View, character: CharacterPar) {
                    if (character.favorite == 1) {
                        view.setBackgroundResource(R.drawable.pic_favorite_empthy)
                        character.favorite = 0
                        viewModel.deleteFromFavorite(character.name)
                    } else {
                        view.setBackgroundResource(R.drawable.pic_favorite)
                        character.favorite = 1
                        viewModel.addToFavorite(character)
                    }
                    getCharacters()

                }
            }, object : DetailClick {
                override fun clickOnCharacter(character: CharacterPar) {
                    findNavController().navigate(
                        FavoritesFragmentDirections.actionFavoriteFragmentToDetailFragment(
                            character
                        )
                    )
                }
            })


        }
    }

    fun getCharacters() {
        viewModel.getAllFavorites()
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFavoritesBinding.inflate(inflater, container, false)

}