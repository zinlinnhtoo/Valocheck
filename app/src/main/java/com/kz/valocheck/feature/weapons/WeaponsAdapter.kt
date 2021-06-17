package com.kz.valocheck.feature.weapons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kz.valocheck.databinding.WeaponsListBinding
import com.kz.valocheck.domain.WeaponsDomain

class WeaponsAdapter(val clickListener: WeaponsOnClickListener) : ListAdapter<WeaponsDomain, WeaponsViewHolder>(WeaponsDiffCallback){

    override fun onBindViewHolder(holder: WeaponsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = WeaponsListBinding.inflate(layoutInflater, parent, false)
        return WeaponsViewHolder(binding)
    }

}

class WeaponsOnClickListener(val clickListener: (weaponId: String) -> Unit) {

    fun onClick(weaponsDomain: WeaponsDomain) {
        clickListener(weaponsDomain.id)
    }

}


class WeaponsViewHolder(val binding: WeaponsListBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(weaponsDomain: WeaponsDomain, clickListener: WeaponsOnClickListener) {
        binding.weapons = weaponsDomain
        binding.clickListener = clickListener
    }
}

object WeaponsDiffCallback: DiffUtil.ItemCallback<WeaponsDomain>() {


    override fun areItemsTheSame(oldItem: WeaponsDomain, newItem: WeaponsDomain): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: WeaponsDomain, newItem: WeaponsDomain): Boolean {
        return oldItem == newItem
    }
}

