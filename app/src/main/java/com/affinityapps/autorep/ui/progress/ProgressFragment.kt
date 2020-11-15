package com.affinityapps.autorep.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.affinityapps.autorep.R

class ProgressFragment : Fragment() {

    private lateinit var progressViewModel: ProgressViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        progressViewModel =
            ViewModelProvider(requireActivity()).get(ProgressViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_progress, container, false)
        val textView: TextView = root.findViewById(R.id.text_test)
        progressViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}