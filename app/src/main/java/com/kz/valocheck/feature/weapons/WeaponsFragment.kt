package com.kz.valocheck.feature.weapons

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.kz.valocheck.R
import com.kz.valocheck.databinding.WeaponsFragmentBinding
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
            adapter.submitList(it)
        })

        weaponsViewModel.navigateToWeaponsData.observe(viewLifecycleOwner, {
            it?.let {
                this.findNavController().navigate(WeaponsFragmentDirections.actionWeaponsFragmentToWeaponsDetailFragment(it))
                weaponsViewModel.onWeaponsDataNavigated()
            }
        })
    }

}