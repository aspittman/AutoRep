package com.affinityapps.autorep.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.affinityapps.autorep.R

class TestFragment : Fragment() {

    private lateinit var testViewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        testViewModel =
            ViewModelProvider(requireActivity()).get(TestViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_test, container, false)
        val textView: TextView = root.findViewById(R.id.text_test)
        testViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}