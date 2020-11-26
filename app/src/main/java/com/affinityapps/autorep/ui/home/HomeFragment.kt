package com.affinityapps.autorep.ui.home

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.autorep.R
import com.affinityapps.autorep.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var autoArrayList: ArrayList<Home>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        toolbar = binding.homeToolbar

        val navHostFragment = NavHostFragment.findNavController(this)
        NavigationUI.setupWithNavController(toolbar, navHostFragment)

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

//        val fab: FloatingActionButton = binding.fab
//        fab.setOnClickListener {
//            addTrackerRow()
//        }
        return binding.root
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.toolbar_menu, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        return when (item.itemId) {
//            R.id.add_row -> {
//                addTrackerRow()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

    private fun addTrackerRow() {
        val dialogBuilder = AlertDialog.Builder(requireActivity())

        dialogBuilder.setMessage("Click add to add a task to the list")
            .setCancelable(false)
            .setPositiveButton("Add", DialogInterface.OnClickListener { dialog, id ->
                //   val bundle = bundleOf("position" to position)
                //   binding.navHostFragment.findNavController().navigate(R.id.fragment_home, bundle)
                val position = 0
                autoArrayList.add(position, Home("aksjdfn", "ksdjbg"))
                homeAdapter.notifyItemInserted(position)
                Log.i(
                    "2Row-Adj",
                    "position is now at $position and arraylist ${autoArrayList.size}"
                )
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("Add Row")
        alert.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}