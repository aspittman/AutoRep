package com.affinityapps.autorep

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.autorep.databinding.ActivityMainBinding
import com.affinityapps.autorep.ui.home.Home
import com.affinityapps.autorep.ui.home.HomeAdapter
import com.affinityapps.autorep.ui.home.HomeFragment
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var autoArrayList: ArrayList<Home>
    private lateinit var homeAdapter: HomeAdapter

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
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragment_home, R.id.fragment_progress, R.id.fragment_settings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.add_row -> {
                addTrackerRow()
                true
            }
            R.id.dark_light -> {
                darkLightMode()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addTrackerRow() {
        val dialogBuilder = AlertDialog.Builder(this)
        autoArrayList = ArrayList()

        dialogBuilder.setMessage("Click add to add a task to the list")
            .setCancelable(false)
            .setPositiveButton("Add", DialogInterface.OnClickListener { dialog, id ->

                autoArrayList.add(Home("aksdjbfgs", "sdfljkgfd"))
                homeAdapter = HomeAdapter(autoArrayList)
                rep_fragment_recyclerview.adapter = homeAdapter
                homeAdapter.notifyDataSetChanged()

            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("Add Row")
        alert.show()
    }

    private fun darkLightMode() {
        val nightMode: Int = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        recreate()
    }
}