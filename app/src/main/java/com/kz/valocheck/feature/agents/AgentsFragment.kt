package com.kz.valocheck.feature.agents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.kz.valocheck.GridSpacingItemDecoration
import com.kz.valocheck.R
import com.kz.valocheck.databinding.AgentsFragmentBinding
import com.kz.valocheck.util.ViewState
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsFragment : Fragment(R.layout.agents_fragment) {

    private val binding by viewBinding(AgentsFragmentBinding::bind)

    private val agentsViewModel: AgentsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AgentsAdapter(AgentsOnClickListener { agentId ->
            agentsViewModel.onAgentsClicked(agentId)
        })

        binding.agentList.apply {
            val spacingInPixels = 16
            this.addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true))
            this.adapter = adapter
        }

        agentsViewModel.navigateToAgentsData.observe(viewLifecycleOwner, {
            it?.let {
                this.findNavController()
                    .navigate(AgentsFragmentDirections.actionAgentsFragmentToAgentsDetailFragment(it))
                agentsViewModel.onAgentsDataNavigated()
            }
        })

        val manager = GridLayoutManager(activity, 2)
        binding.agentList.layoutManager = manager

        agentsViewModel.agentList.observe(viewLifecycleOwner, {
            when (it) {
                is ViewState.Loading -> {
                    binding.agentList.isVisible = false
                    binding.loading.isVisible = true
                }
                is ViewState.Success -> {
                    binding.loading.isVisible = false
                    binding.agentList.isVisible = true
                    adapter.submitList(it.data)
                }
                is ViewState.Error -> {
                    binding.loading.isVisible = false
                    Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        })


        agentsViewModel.roleList.observe(viewLifecycleOwner, { roles ->


            val chipInflater = LayoutInflater.from(requireContext())

            roles.forEachIndexed { index, role ->

                chipInflater.inflate(R.layout.role_chip, binding.roleList, false)
                    .let { view -> view as Chip }
                    .apply {
                        text = role
                    }
                    .also {
                        binding.roleList.addView(it)
                        if (role == agentsViewModel.checkedRoleName) {
                            it.isChecked = true
                        }
                    }

            }
        })

        binding.roleList.setOnCheckedChangeListener { group, checkedId ->

            val checkedChip = group.findViewById<Chip>(checkedId)

            val checkedRoleName = checkedChip?.text

            agentsViewModel.filter(checkedRoleName?.toString())

            Log.i("AgentFragment", checkedRoleName.toString() + System.currentTimeMillis())

        }
    }
}
