package com.kz.valocheck.feature.agents

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.kz.valocheck.R
import com.kz.valocheck.databinding.AgentDetailFragmentBinding
import com.kz.valocheck.util.SpringAddItemAnimator
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsDetailFragment: Fragment(R.layout.agent_detail_fragment) {

    private val binding by viewBinding(AgentDetailFragmentBinding::bind)
    private val agentsDetailViewModel : AgentsDetailViewModel by viewModels()
    private val args by navArgs<AgentsDetailFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            // Scope the transition to a view in the hierarchy so we know it will be added under
            // the bottom app bar but over the elevation scale of the exiting HomeFragment.
            drawingViewId = R.id.nav_host_fragment
            duration = 500.toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(Color.WHITE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        postponeEnterTransition()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AbilityAdapter()
        binding.abilityList.adapter = adapter
        binding.abilityList.itemAnimator = SpringAddItemAnimator()

        agentsDetailViewModel.getAgentDetail(args.id)

        agentsDetailViewModel.agentDetail.observe(viewLifecycleOwner, {
            binding.agentsDomain = it
            binding.executePendingBindings()
            adapter.submitList(it.abilities)
            startPostponedEnterTransition()
        })



    }

}