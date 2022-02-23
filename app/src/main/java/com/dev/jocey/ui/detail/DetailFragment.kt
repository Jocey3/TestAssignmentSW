package com.dev.jocey.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.jocey.R
import com.dev.jocey.databinding.FragmentDetailBinding
import com.dev.jocey.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    private val args by navArgs<DetailFragmentArgs>()
    private val viewModel: DetailViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }


    private fun initViews() {
        if (args.deatail.favorite == 1) {
            binding.imDetailFavorite.setBackgroundResource(R.drawable.pic_favorite)
        } else {
            binding.imDetailFavorite.setBackgroundResource(R.drawable.pic_favorite_empthy)
        }
        binding.tvDetailName.text = args.deatail.name
        binding.tvDetailBd.text = args.deatail.birth_year
        binding.tvDetailGender.text = args.deatail.gender
        binding.deatailFilms.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        viewModel.films.observe(viewLifecycleOwner) {
            binding.deatailFilms.adapter = FilmsAdapter(it)
        }
        binding.imDetailFavorite.setOnClickListener {
            if (args.deatail.favorite == 1) {
                deleteFromDb()
                binding.imDetailFavorite.setBackgroundResource(R.drawable.pic_favorite_empthy)
            } else {
                addToDB()
                binding.imDetailFavorite.setBackgroundResource(R.drawable.pic_favorite)

            }
        }

    }

    private fun deleteFromDb() {
        viewModel.deleteFromDb(args.deatail.name)

    }


    private fun addToDB() {
        viewModel.addToDB(args.deatail)
    }

    override fun onResume() {
        super.onResume()

        viewModel.getFilmTitles(args.deatail.films)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDetailBinding.inflate(inflater, container, false)
}