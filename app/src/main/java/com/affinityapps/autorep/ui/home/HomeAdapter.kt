package com.affinityapps.autorep.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.autorep.databinding.RepListItemsBinding

class HomeAdapter(
    private val autoFragmentArrayList: List<Home>,
) :
    RecyclerView.Adapter<HomeAdapter.RepFragmentViewHolder>() {

    inner class RepFragmentViewHolder(binding: RepListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var nameTextView: TextView = binding.dataName
        var numberTextView: TextView = binding.dataNumber
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepFragmentViewHolder {
        return RepFragmentViewHolder(
            RepListItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RepFragmentViewHolder, position: Int) {

        val home: Home = autoFragmentArrayList[position]
        holder.nameTextView.text = home.name
        holder.numberTextView.text = home.number
        Log.d("Binding-Adj", "Position is at $position")
    }

    override fun getItemCount() = autoFragmentArrayList.size
}