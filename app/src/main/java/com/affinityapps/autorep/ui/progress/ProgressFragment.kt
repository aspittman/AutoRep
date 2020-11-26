package com.affinityapps.autorep.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.affinityapps.autorep.R
import com.affinityapps.autorep.databinding.FragmentHomeBinding
import com.affinityapps.autorep.databinding.FragmentProgressBinding

class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null
    private val binding get() = _binding!!

    private lateinit var progressViewModel: ProgressViewModel
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        toolbar = binding.progressToolbar

        val navHostFragment = NavHostFragment.findNavController(this)
        NavigationUI.setupWithNavController(toolbar, navHostFragment)

        progressViewModel =
            ViewModelProvider(requireActivity()).get(ProgressViewModel::class.java)
        val textView: TextView = binding.textTest
        progressViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}