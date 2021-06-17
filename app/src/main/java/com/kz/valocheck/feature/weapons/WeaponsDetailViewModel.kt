package com.kz.valocheck.feature.weapons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kz.valocheck.domain.WeaponStatsDomain
import com.kz.valocheck.domain.WeaponsDomain
import com.kz.valocheck.repo.WeaponsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponsDetailViewModel @Inject constructor(private val weaponsRepo: WeaponsRepo) : ViewModel() {

    private val _weaponDetail = MutableLiveData<WeaponsDomain>()
    val weaponDetail : LiveData<WeaponsDomain>
    get() = _weaponDetail

    fun getWeaponsDetail(weaponId: String) {

        viewModelScope.launch {
            _weaponDetail.value = weaponsRepo.getWeaponsDetail(weaponId)
        }

    }
}