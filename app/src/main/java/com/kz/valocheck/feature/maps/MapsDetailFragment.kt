package com.kz.valocheck.feature.maps

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.kz.valocheck.R
import com.kz.valocheck.databinding.MapDetailFragmentBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsDetailFragment: Fragment(R.layout.map_detail_fragment) {

    private val binding by viewBinding(MapDetailFragmentBinding::bind)
    private val mapsDetailViewModel : MapsDetailViewModel by viewModels()
    private val args by navArgs<MapsDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapsDetailViewModel.getMapsDetail(args.mapId)
        mapsDetailViewModel.mapDetail.observe(viewLifecycleOwner, {
            binding.mapDomain = it
        })
    }
}