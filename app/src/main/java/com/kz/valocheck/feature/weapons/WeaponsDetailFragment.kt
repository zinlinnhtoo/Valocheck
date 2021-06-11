package com.kz.valocheck.feature.weapons

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.kz.valocheck.R
import com.kz.valocheck.databinding.WeaponDetailFragmentBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeaponsDetailFragment: Fragment(R.layout.weapon_detail_fragment) {

    private val binding by viewBinding(WeaponDetailFragmentBinding::bind)
    private val weaponDetailViewModel : WeaponsDetailViewModel by viewModels()
    private val args by navArgs<WeaponsDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weaponDetailViewModel.getWeaponsDetail(args.weaponId)

        weaponDetailViewModel.weaponDetail.observe(viewLifecycleOwner, {
            binding.weaponDomain = it
        })


    }
}