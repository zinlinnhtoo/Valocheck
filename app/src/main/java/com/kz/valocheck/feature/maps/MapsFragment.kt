package com.kz.valocheck.feature.maps

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
import com.kz.valocheck.R
import com.kz.valocheck.databinding.MapsFragmentBinding
import com.kz.valocheck.util.ViewState
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapsFragment : Fragment(R.layout.maps_fragment) {

    private val binding by viewBinding(MapsFragmentBinding::bind)

    private val mapsViewModel: MapsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MapAdapter(MapsOnClickListener {
            mapId -> mapsViewModel.onMapsClicked(mapId)
        })

        binding.mapList.adapter = adapter

        mapsViewModel.navigateToMapData.observe(viewLifecycleOwner, {
            it?.let {
                this.findNavController().navigate(MapsFragmentDirections.actionMapsFragmentToMapDetailFragment(it))
                mapsViewModel.onMapsNavigated()
            }
        })

        mapsViewModel.mapsList.observe(viewLifecycleOwner, {
            when(it){
                is ViewState.Loading -> {
                    binding.mapList.isVisible = false
                    binding.loading.isVisible = true
                }
                is  ViewState.Success -> {
                    binding.loading.isVisible = false
                    binding.mapList.isVisible = true
                    adapter.submitList(it.data)
                }
                is ViewState.Error -> {
                    binding.loading.isVisible = false
                    Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}