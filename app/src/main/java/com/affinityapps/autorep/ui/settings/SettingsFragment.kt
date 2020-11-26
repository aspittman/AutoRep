package com.affinityapps.autorep.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.affinityapps.autorep.R
import com.affinityapps.autorep.databinding.FragmentHomeBinding
import com.affinityapps.autorep.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private lateinit var settingsViewModel: SettingsViewModel
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        toolbar = binding.settingsToolbar

        val navHostFragment = NavHostFragment.findNavController(this)
        NavigationUI.setupWithNavController(toolbar, navHostFragment)

        settingsViewModel =
            ViewModelProvider(requireActivity()).get(SettingsViewModel::class.java)
        val textView: TextView = binding.textSettings
        settingsViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return binding.root
    }

    private fun darkLightMode() {
        val nightMode: Int = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        //  recreate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}