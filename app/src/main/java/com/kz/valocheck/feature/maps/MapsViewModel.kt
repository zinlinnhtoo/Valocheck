package com.kz.valocheck.feature.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kz.valocheck.domain.MapsDomain
import com.kz.valocheck.repo.MapsRepo
import com.kz.valocheck.util.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(private val mapsRepo: MapsRepo) : ViewModel() {

    private val _mapsList = MutableLiveData<ViewState<List<MapsDomain>>>()
    val mapsList : LiveData<ViewState<List<MapsDomain>>>
        get() = _mapsList

    fun getMapsList() {

        viewModelScope.launch {
           try {
               _mapsList.value = ViewState.Loading
               _mapsList.value = ViewState.Success(mapsRepo.getMapsList())
           }catch (e: Exception) {
               _mapsList.value = ViewState.Error(e)
           }
        }

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