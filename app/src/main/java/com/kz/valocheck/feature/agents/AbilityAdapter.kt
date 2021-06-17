package com.kz.valocheck.feature.agents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kz.valocheck.databinding.AbilityListBinding
import com.kz.valocheck.domain.AbilityDomain

class AbilityAdapter : ListAdapter<AbilityDomain, AbilityViewHolder>(AbilityDiffCallback) {

    override fun onBindViewHolder(holder: AbilityViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AbilityListBinding.inflate(layoutInflater, parent, false)
        return AbilityViewHolder(binding)
    }
}

class AbilityViewHolder(val binding: AbilityListBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(abilityDomain: AbilityDomain) {
        binding.ability = abilityDomain
    }

}

object AbilityDiffCallback: DiffUtil.ItemCallback<AbilityDomain>() {

    override fun areItemsTheSame(oldItem: AbilityDomain, newItem: AbilityDomain): Boolean {
        return oldItem.slot == newItem.slot
    }

    override fun areContentsTheSame(oldItem: AbilityDomain, newItem: AbilityDomain): Boolean {
        return oldItem == newItem
    }
}