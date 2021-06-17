package com.kz.valocheck.feature.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kz.valocheck.domain.MapsDomain
import com.kz.valocheck.repo.MapsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsDetailViewModel @Inject constructor(val mapsRepo: MapsRepo): ViewModel() {

    private val _mapDetail = MutableLiveData<MapsDomain>()
    val mapDetail : LiveData<MapsDomain>
    get() = _mapDetail

    fun getMapsDetail(mapId: String) {

        viewModelScope.launch {
            _mapDetail.value = mapsRepo.getMapsDetail(mapId)
        }

    }

}