package com.affinityapps.autorep.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.autorep.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var autoArrayList: ArrayList<Home>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        autoArrayList = ArrayList()
        autoArrayList.add(Home("aksdjbfgs", "sdfljkgfd"))
        autoArrayList.add(Home("asdfsdfds", "fdasfdsfs"))
        autoArrayList.add(Home("aksdjbfgs", "sdfljkgfd"))
        autoArrayList.add(Home("aksdjbfgs", "sdfljkgfd"))
        autoArrayList.add(Home("aksdjbfgs", "sdfljkgfd"))

        viewManager = LinearLayoutManager(activity)
        homeAdapter = HomeAdapter(autoArrayList)

        recyclerView = binding.repFragmentRecyclerview.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = homeAdapter
        }
        return binding.root
    }
}