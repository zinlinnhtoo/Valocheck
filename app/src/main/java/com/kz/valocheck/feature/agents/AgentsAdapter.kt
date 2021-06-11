package com.kz.valocheck.feature.agents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kz.valocheck.databinding.AgentsListBinding
import com.kz.valocheck.domain.AgentsDomain

class AgentsAdapter(val clickListener: AgentsOnClickListener) : ListAdapter<AgentsDomain, AgentsViewHolder>(AgentsDiffCallback) {


    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AgentsListBinding.inflate(layoutInflater, parent, false)
        return AgentsViewHolder(binding)
    }
}

class AgentsViewHolder(val binding: AgentsListBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(agentsDomain: AgentsDomain, clickListener: AgentsOnClickListener) {
        binding.agentProfileImage.setImageResource(agentsDomain.profile)
        binding.agentProfileName.text = agentsDomain.name
        binding.agent = agentsDomain
        binding.clickListner = clickListener
    }

}

class AgentsOnClickListener(val clickListener: (agentsId : String) -> Unit){
    fun onClick(agentsDomain: AgentsDomain) {
        clickListener(agentsDomain.id)
    }
}

object AgentsDiffCallback: DiffUtil.ItemCallback<AgentsDomain>() {

    override fun areItemsTheSame(oldItem: AgentsDomain, newItem: AgentsDomain): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AgentsDomain, newItem: AgentsDomain): Boolean {
        return oldItem == newItem
    }
}