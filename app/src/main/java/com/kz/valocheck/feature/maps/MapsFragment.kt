package com.kz.valocheck.feature.maps

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kz.valocheck.R
import com.kz.valocheck.databinding.MapsFragmentBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class MapsFragment : Fragment(R.layout.maps_fragment) {

    private val binding by viewBinding(MapsFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mapsText = "Map"
    }
}