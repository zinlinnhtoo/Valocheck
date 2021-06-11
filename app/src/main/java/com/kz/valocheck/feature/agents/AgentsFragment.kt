package com.kz.valocheck.feature.agents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.kz.valocheck.R
import com.kz.valocheck.databinding.AgentsFragmentBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsFragment : Fragment(R.layout.agents_fragment) {

    private val binding by viewBinding(AgentsFragmentBinding::bind)

    private val agentsViewModel: AgentsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AgentsAdapter(AgentsOnClickListener {
                agentId -> agentsViewModel.onAgentsClicked(agentId)
        })
        binding.agentList.adapter = adapter

        agentsViewModel.navigateToAgentsData.observe(viewLifecycleOwner, {
            it?.let {
                this.findNavController().navigate(AgentsFragmentDirections.actionAgentsFragmentToAgentsDetailFragment(it))
                agentsViewModel.onAgentsDataNavigated()
            }
        })

        val manager = GridLayoutManager(activity, 2)
        binding.agentList.layoutManager = manager

        agentsViewModel.agentList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }
}
