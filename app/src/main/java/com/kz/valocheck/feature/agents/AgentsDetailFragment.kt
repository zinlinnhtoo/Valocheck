package com.kz.valocheck.feature.agents

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.kz.valocheck.R
import com.kz.valocheck.databinding.AgentDetailFragmentBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsDetailFragment: Fragment(R.layout.agent_detail_fragment) {

    private val binding by viewBinding(AgentDetailFragmentBinding::bind)
    private val agentsDetailViewModel : AgentsDetailViewModel by viewModels()
    private val args by navArgs<AgentsDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AbilityAdapter()
        binding.abilityList.adapter = adapter

        agentsDetailViewModel.getAgentDetail(args.id)

        agentsDetailViewModel.agentDetail.observe(viewLifecycleOwner, {
            binding.agentsDomain = it
            adapter.submitList(it.abilities)
        })



    }

}