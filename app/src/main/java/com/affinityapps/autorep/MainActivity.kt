package com.affinityapps.autorep

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.autorep.databinding.ActivityMainBinding
import com.affinityapps.autorep.ui.home.Home
import com.affinityapps.autorep.ui.home.HomeAdapter
import com.affinityapps.autorep.ui.home.HomeFragment
import com.affinityapps.autorep.ui.home.MainHomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
  //  private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableNavigation()
    }

    private fun enableNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.fragment_home, R.id.fragment_progress, R.id.fragment_settings
//            )
//        )
        binding.navView.setupWithNavController(navController)
    }
}