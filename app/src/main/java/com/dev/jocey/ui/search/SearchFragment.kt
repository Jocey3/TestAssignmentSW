package com.dev.jocey.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.jocey.databinding.FragmentSearchBinding
import com.dev.jocey.model.network.CharacterEntity
import com.dev.jocey.ui.BaseFragment
import com.dev.jocey.utils.CharacterListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private val viewModel: SearchViewModel by viewModels()
    private var job: Job? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listSearch.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        viewModel.result.observe(
            viewLifecycleOwner
        ) {
            binding.listSearch.adapter = CharacterListAdapter(it, requireContext())

        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                job?.cancel()
                job = CoroutineScope(Dispatchers.IO).launch {
                    if (p0 != "")
                        viewModel.loadCharacters(p0 ?: "")
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                job?.cancel()
                job = CoroutineScope(Dispatchers.IO).launch {
                    delay(1000L)
                    if (p0 != "")
                        viewModel.loadCharacters(p0 ?: "")
                    else {

                    }
                }
                return false
            }
        })

    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSearchBinding.inflate(inflater, container, false)
}