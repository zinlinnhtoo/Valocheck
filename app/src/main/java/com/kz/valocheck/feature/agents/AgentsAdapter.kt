package com.kz.valocheck.feature.agents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kz.valocheck.databinding.AgentsListBinding
import com.kz.valocheck.domain.AgentsDomain

class AgentsAdapter(
    val clickListener: (AgentsDomain, View, View, View) -> Unit
) : ListAdapter<AgentsDomain, AgentsViewHolder>(AgentsDiffCallback) {


    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AgentsListBinding.inflate(layoutInflater, parent, false)
        return AgentsViewHolder(binding, clickListener)
    }
}

class AgentsViewHolder(
    private val binding: AgentsListBinding,
    private val clickListener: (AgentsDomain, View, View, View) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    private var _data: AgentsDomain? = null
    private val data: AgentsDomain
        get() = _data!!

    init {
        binding.root.setOnClickListener {
            clickListener(data, it, binding.agentProfileName, binding.agentProfileImage)
        }
    }

    fun bind(agentsDomain: AgentsDomain) {
        _data = agentsDomain
        binding.agentProfileName.text = agentsDomain.name
        binding.agent = agentsDomain
        binding.executePendingBindings()
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