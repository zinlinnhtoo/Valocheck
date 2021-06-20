package com.kz.valocheck.repo

import com.kz.valocheck.database.dao.MapDao
import com.kz.valocheck.database.entity.MapEntity
import com.kz.valocheck.domain.MapsDomain
import com.kz.valocheck.network.ValorantApiService
import com.kz.valocheck.network.asDomain
import java.lang.Exception
import javax.inject.Inject

class MapsRepo @Inject constructor(
    private val valorantApiService: ValorantApiService,
    private val mapDao: MapDao ) {


    suspend fun getMapsList() : List<MapsDomain> {

        try {

            val mapEntites = valorantApiService.getMapList().body()?.data?.map {
                MapEntity(
                    id = it.id.orEmpty(),
                    name = it.name.orEmpty(),
                    coordinate = it.coordinate.orEmpty(),
                    mapImg = it.mapImg.orEmpty(),
                    miniMapImg = it.miniMapImg.orEmpty(),
                    splash = it.splash.orEmpty()
                )
            }.orEmpty()

            mapDao.insert(*mapEntites.toTypedArray())

        } catch (e: Exception) {

        }

        return mapDao.getList().map {
           it.asDomain()
        }

    }

    suspend fun getMapsDetail(id: String): MapsDomain {
        return mapDao.get(id).asDomain()
    }

    private fun MapEntity.asDomain() : MapsDomain {
        return  MapsDomain(
            id = id,
            name = name,
            coordinate = coordinate,
            mapImg = mapImg,
            miniMapImg = miniMapImg,
            splash = splash
        )
    }
}

