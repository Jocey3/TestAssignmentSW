package com.dev.jocey.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.dev.jocey.di.App

abstract class BaseFragment<T : ViewBinding> : Fragment() {
    private var _viewBinding: T? = null
    protected val binding
        get() = checkNotNull(_viewBinding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _viewBinding = initBinding(inflater, container)
        return binding.root
    }

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}