package com.kz.valocheck.repo

import com.kz.valocheck.domain.MapsDomain
import com.kz.valocheck.network.ValorantApiService
import com.kz.valocheck.network.asDomain
import javax.inject.Inject

class MapsRepo @Inject constructor(private val valorantApiService: ValorantApiService) {


    suspend fun getMapsList() : List<MapsDomain> {
        return valorantApiService.getMapList().body().asDomain()
    }

    suspend fun getMapsDetail(id: String): MapsDomain {
        return valorantApiService.getMapDetail(id).body()?.data.asDomain()
    }
}

