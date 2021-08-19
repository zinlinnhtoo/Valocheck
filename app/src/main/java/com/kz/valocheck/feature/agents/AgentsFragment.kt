package com.kz.valocheck.feature.agents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.view.doOnPreDraw
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.google.android.material.transition.MaterialElevationScale
import com.google.android.material.transition.MaterialFadeThrough
import com.kz.valocheck.GridSpacingItemDecoration
import com.kz.valocheck.R
import com.kz.valocheck.databinding.AgentsFragmentBinding
import com.kz.valocheck.util.SpringAddItemAnimator
import com.kz.valocheck.util.ViewState
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsFragment : Fragment(R.layout.agents_fragment) {

    private val binding by viewBinding(AgentsFragmentBinding::bind)

    private val agentsViewModel: AgentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough().apply {
            duration = 500.toLong()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        val adapter = AgentsAdapter { agent, container, textView, imageView ->
            val extras: FragmentNavigator.Extras =
                FragmentNavigatorExtras(
                    container to getString(R.string.trans_detail),
                    textView to getString(R.string.trans_label),
                    imageView to getString(R.string.trans_image)
                )
            findNavController().navigate(
                AgentsFragmentDirections.actionAgentsFragmentToAgentsDetailFragment(
                    agent.id
                ), extras
            )
        }

        binding.agentList.apply {
            itemAnimator = SpringAddItemAnimator()
            val spacingInPixels = 16
            this.addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true))
            this.adapter = adapter
        }

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
