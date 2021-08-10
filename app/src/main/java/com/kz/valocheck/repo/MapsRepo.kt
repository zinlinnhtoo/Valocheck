package com.kz.valocheck.repo

import com.kz.valocheck.database.dao.MapDao
import com.kz.valocheck.domain.MapsDomain
import com.kz.valocheck.mapper.asDomain
import com.kz.valocheck.mapper.asEntity
import com.kz.valocheck.network.ValorantApiService
import javax.inject.Inject

class MapsRepo @Inject constructor(
    private val valorantApiService: ValorantApiService,
    private val mapDao: MapDao ) {


    suspend fun getMapsList() : List<MapsDomain> {

        saveMapsList()

        return mapDao.getList().map {
           it.asDomain()
        }

    }

    private suspend fun saveMapsList() {
        try {

            val mapEntities = valorantApiService.getMapList().body()?.data?.map {
                it.asEntity()
            }.orEmpty()

            mapDao.insert(*mapEntities.toTypedArray())

        } catch (e: Exception) {

        }
    }

    suspend fun getMapsDetail(id: String): MapsDomain {
        return mapDao.get(id).asDomain()
    }


}

