package com.affinityapps.autorep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.autorep.databinding.FragmentRepBinding

class RepFragment : Fragment(){
    private var _binding: FragmentRepBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var repAdapter: RepAdapter
    private lateinit var autoArrayList: ArrayList<Rep>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepBinding.inflate(inflater, container, false)

        autoArrayList = ArrayList()
        autoArrayList.add(Rep("aksdjbfgs", "sdfljkgfd"))
        autoArrayList.add(Rep("asdfsdfds", "fdasfdsfs"))
        autoArrayList.add(Rep("aksdjbfgs", "sdfljkgfd"))
        autoArrayList.add(Rep("aksdjbfgs", "sdfljkgfd"))
        autoArrayList.add(Rep("aksdjbfgs", "sdfljkgfd"))

        viewManager = LinearLayoutManager(activity)
        repAdapter = RepAdapter(autoArrayList)

        recyclerView = binding.repFragmentRecyclerview.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = repAdapter
        }
        return binding.root
    }
}