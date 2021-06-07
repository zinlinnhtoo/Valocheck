package com.kz.valocheck.feature.agents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.kz.valocheck.R
import com.kz.valocheck.databinding.AgentsFragmentBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class AgentsFragment : Fragment(R.layout.agents_fragment) {

   private val binding by viewBinding(AgentsFragmentBinding::bind)

    private val viewModel = AgentsViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text = "Agents"
        binding.text2 = "Agents 2"


    }
}
