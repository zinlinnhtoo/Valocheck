package com.kz.valocheck.feature.weapons

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.kz.valocheck.R
import com.kz.valocheck.databinding.WeaponsFragmentBinding
import com.kz.valocheck.util.ViewState
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeaponsFragment : Fragment(R.layout.weapons_fragment) {

    private val binding by viewBinding(WeaponsFragmentBinding::bind)

    private val weaponsViewModel: WeaponsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = WeaponsAdapter(WeaponsOnClickListener {
            weaponId -> weaponsViewModel.onWeaponsClicked(weaponId)
        })
        binding.weaponList.adapter = adapter

        val manager = GridLayoutManager(activity, 2)
        binding.weaponList.layoutManager = manager

        weaponsViewModel.weaponList.observe(viewLifecycleOwner, {
            when(it){
                is ViewState.Loading -> {
                    binding.weaponList.isVisible = false
                    binding.loading.isVisible = true
                }
                is  ViewState.Success -> {
                    binding.loading.isVisible = false
                    binding.weaponList.isVisible = true
                    adapter.submitList(it.data)
                }
                is ViewState.Error -> {
                    binding.loading.isVisible = false
                    Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        })

        weaponsViewModel.navigateToWeaponsData.observe(viewLifecycleOwner, {
            it?.let {
                this.findNavController().navigate(WeaponsFragmentDirections.actionWeaponsFragmentToWeaponsDetailFragment(it))
                weaponsViewModel.onWeaponsDataNavigated()
            }
        })
    }

}