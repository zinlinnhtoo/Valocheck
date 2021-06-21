package com.kz.valocheck.repo

import android.util.Log
import com.kz.valocheck.database.dao.DamageRangeDao
import com.kz.valocheck.database.dao.WeaponDao
import com.kz.valocheck.database.entity.DamageRangeEntity
import com.kz.valocheck.domain.WeaponsDomain
import com.kz.valocheck.mapper.asDomain
import com.kz.valocheck.mapper.asEntity
import com.kz.valocheck.network.ValorantApiService
import javax.inject.Inject

class WeaponsRepo @Inject constructor(
    private val valorantApiService: ValorantApiService,
    private val weaponDao: WeaponDao,
    private val dmgRangeDao: DamageRangeDao
) {


    suspend fun getWeaponsList(): List<WeaponsDomain> {

        try {

            val apiResult = valorantApiService.getWeaponList().body()?.data

            val weaponEntities = apiResult?.map {
                it.asEntity()
            }.orEmpty()

            val dmgRangeEntities: List<DamageRangeEntity?>? = apiResult?.flatMap { weaponDto ->
                weaponDto.weaponStats?.dmgRange?.map { damageRange ->
                    damageRange.asEntity(weaponDto)
                }.orEmpty()
            }

            weaponDao.insert(*weaponEntities.toTypedArray())

            dmgRangeEntities?.let {
                dmgRangeDao.insert(*it.filterNotNull().toTypedArray())
            }


        } catch (e: Exception) {
            Log.e("error", "error")
        }

        return weaponDao.getList().map {
            it.asDomain()
        }
    }

    suspend fun getWeaponsDetail(id: String): WeaponsDomain {
        return weaponDao.get(id).asDomain()
    }


}