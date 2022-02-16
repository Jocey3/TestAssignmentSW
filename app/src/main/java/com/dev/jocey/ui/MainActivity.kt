package com.dev.jocey.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.dev.jocey.R
import com.dev.jocey.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("mylog", "rem")

        val navControler = findNavController(R.id.fragment_main)
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.searchFragment, R.id.favoriteFragment))
        setupActionBarWithNavController(
            this,
            navControler,
            appBarConfiguration
        )
        setupWithNavController(binding.navBottom, navControler)


    }

}