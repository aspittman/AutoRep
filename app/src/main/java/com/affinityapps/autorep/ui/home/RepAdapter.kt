package com.affinityapps.autorep.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.autorep.databinding.RepListItemsBinding

class RepAdapter(
    private val autoFragmentArrayList: List<Rep>,
) :
    RecyclerView.Adapter<RepAdapter.RepFragmentViewHolder>() {

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

        val rep: Rep = autoFragmentArrayList[position]
        holder.nameTextView.text = rep.name
        holder.numberTextView.text = rep.number

    }

    override fun getItemCount() = autoFragmentArrayList.size
}