package com.kz.valocheck.feature.weapons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kz.valocheck.domain.WeaponsDomain
import com.kz.valocheck.repo.WeaponsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(private val weaponsRepo: WeaponsRepo): ViewModel() {

    private val _weaponList = MutableLiveData<List<WeaponsDomain>>()
    val weaponList : LiveData<List<WeaponsDomain>>
    get() = _weaponList

    fun getWeaponsList() {
        _weaponList.value = weaponsRepo.getWeaponsList()
    }

    init {
        getWeaponsList()
    }

    private val _navigateToWeaponsData = MutableLiveData<String?>()
    val navigateToWeaponsData : LiveData<String?>
    get() = _navigateToWeaponsData

    fun onWeaponsClicked(weaponId: String) {
        _navigateToWeaponsData.value = weaponId
    }
    fun onWeaponsDataNavigated() {
        _navigateToWeaponsData.value = null
    }
}