package com.kz.valocheck.repo

import com.kz.valocheck.domain.WeaponsDomain
import com.kz.valocheck.network.ValorantApiService
import com.kz.valocheck.network.asDomain
import javax.inject.Inject

class WeaponsRepo @Inject constructor(private val valorantApiService: ValorantApiService) {


    suspend fun getWeaponsList(): List<WeaponsDomain> {
        return valorantApiService.getWeaponList().body().asDomain()

    }

    suspend fun getWeaponsDetail(id: String): WeaponsDomain {
        return valorantApiService.getWeaponDetail(id).body()?.data.asDomain()
    }



}