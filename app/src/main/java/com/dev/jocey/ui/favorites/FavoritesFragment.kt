package com.dev.jocey.ui.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.jocey.R
import com.dev.jocey.databinding.FragmentFavoritesBinding
import com.dev.jocey.databinding.FragmentSearchBinding
import com.dev.jocey.ui.BaseFragment

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFavoritesBinding.inflate(inflater, container, false)

}