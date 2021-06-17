package com.kz.valocheck.feature.weapons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kz.valocheck.domain.WeaponsDomain
import com.kz.valocheck.repo.WeaponsRepo
import com.kz.valocheck.util.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(private val weaponsRepo: WeaponsRepo): ViewModel() {

    private val _weaponList = MutableLiveData<ViewState<List<WeaponsDomain>>>()
    val weaponList : LiveData<ViewState<List<WeaponsDomain>>>
    get() = _weaponList

    fun getWeaponsList() {

        viewModelScope.launch {
            try {
                _weaponList.value = ViewState.Loading
                _weaponList.value = ViewState.Success(weaponsRepo.getWeaponsList())
            }catch (e: Exception) {
                _weaponList.value = ViewState.Error(e)
            }
        }

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