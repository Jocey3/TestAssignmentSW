package com.dev.jocey.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.jocey.R
import com.dev.jocey.databinding.FragmentSearchBinding
import com.dev.jocey.ui.BaseFragment
import com.dev.jocey.ui.search.util.DetailClick
import com.dev.jocey.ui.search.util.FavoritesClick
import com.dev.jocey.ui.search.util.SearchAdapter
import com.dev.jocey.utils.InternetConnection
import com.dev.jocey.utils.entityes.CharacterPar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private val viewModel: SearchViewModel by viewModels()
    private var job: Job? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listSearch.layoutManager = LinearLayoutManager(requireContext())
        viewModel.result.observe(viewLifecycleOwner) {
            binding.listSearch.adapter = SearchAdapter(it, object : FavoritesClick {
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
                }
            }, object : DetailClick {
                override fun clickOnCharacter(character: CharacterPar) {
                    findNavController().navigate(
                        SearchFragmentDirections.actionSearchFragmentToDetailFragment(
                            character
                        )
                    )
                }
            })

        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (InternetConnection.isOnline(requireContext())) {
                    p0?.let { viewModel.searchCharacters(it) }
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (InternetConnection.isOnline(requireContext())) {
                    p0?.let { viewModel.searchCharacters(it) }
                }
                return false
            }
        })

    }

    override fun onStop() {
        job?.cancel()
        super.onStop()
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSearchBinding.inflate(inflater, container, false)
}