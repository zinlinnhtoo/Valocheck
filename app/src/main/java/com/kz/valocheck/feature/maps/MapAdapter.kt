package com.kz.valocheck.feature.maps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kz.valocheck.databinding.MapsListBinding
import com.kz.valocheck.domain.MapsDomain

class MapAdapter(val clickListener: MapsOnClickListener) : ListAdapter<MapsDomain, MapsViewHolder>(MapsDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MapsListBinding.inflate(layoutInflater, parent, false)
        return MapsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MapsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
}



class MapsViewHolder(val binding: MapsListBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(mapsDomain: MapsDomain, clickListener: MapsOnClickListener){
        binding.mapDomain = mapsDomain
        binding.clickListener = clickListener
    }
}

class MapsOnClickListener(val clickListener: (mapId : String) -> Unit) {
    fun onClick(mapsDomain: MapsDomain) {
        clickListener(mapsDomain.id)
    }

}

object MapsDiffCallback: DiffUtil.ItemCallback<MapsDomain>() {
    override fun areItemsTheSame(oldItem: MapsDomain, newItem: MapsDomain): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MapsDomain, newItem: MapsDomain): Boolean {
        return oldItem == newItem
    }
}
