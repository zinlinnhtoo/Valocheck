package com.kz.valocheck.feature.weapons

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kz.valocheck.R
import com.kz.valocheck.databinding.WeaponsFragmentBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class WeaponsFragment : Fragment(R.layout.weapons_fragment) {

   private val binding by viewBinding(WeaponsFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.weaponText = "Weapons"
    }

}