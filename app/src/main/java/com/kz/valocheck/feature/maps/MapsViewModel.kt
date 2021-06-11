package com.kz.valocheck.feature.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kz.valocheck.domain.MapsDomain
import com.kz.valocheck.repo.MapsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(private val mapsRepo: MapsRepo) : ViewModel() {

    private val _mapsList = MutableLiveData<List<MapsDomain>>()
    val mapsList : LiveData<List<MapsDomain>>
        get() = _mapsList

    fun getMapsList() {
        _mapsList.value = mapsRepo.getMapsList()
    }

    init {
        getMapsList()
    }

    private val _navigateToMapData = MutableLiveData<String?>()
    val navigateToMapData : LiveData<String?>
    get() = _navigateToMapData

    fun  onMapsClicked(mapId: String){
        _navigateToMapData.value = mapId
    }

    fun onMapsNavigated() {
        _navigateToMapData.value = null
    }
}