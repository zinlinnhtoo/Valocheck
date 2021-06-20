package com.kz.valocheck.repo

import android.util.Log
import com.kz.valocheck.database.dao.DamageRangeDao
import com.kz.valocheck.database.dao.WeaponDao
import com.kz.valocheck.database.entity.*
import com.kz.valocheck.domain.DamageRangeDomain
import com.kz.valocheck.domain.ShopDataDomain
import com.kz.valocheck.domain.WeaponStatsDomain
import com.kz.valocheck.domain.WeaponsDomain
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
                WeaponEntity(
                    id = it.id.orEmpty(),
                    name = it.name.orEmpty(),
                    category = it.category.orEmpty(),
                    weaponImg = it.weaponImg.orEmpty(),
                    weaponStats = it.weaponStats.let { weaponStatsDto ->
                        WeaponStatsEntity(
                            fireRate = weaponStatsDto?.fireRate.orEmpty(),
                            magazineSize = weaponStatsDto?.magazineSize.orEmpty(),
                            runSpeedMultiplier = weaponStatsDto?.runSpeedMultiplier.orEmpty(),
                            equipTimeSecond = weaponStatsDto?.equipTimeSecond.orEmpty(),
                            reloadTimeSecond = weaponStatsDto?.reloadTimeSecond.orEmpty(),
                            wallPenetration = weaponStatsDto?.wallPenetration.orEmpty(),
                            fireMode = weaponStatsDto?.fireMode.orEmpty()
                        )
                    },
                    shopData = it.shopData.let { shopDataDto ->
                        ShopDataEntity(
                            cost = shopDataDto?.cost.orEmpty(),
                            category = shopDataDto?.category.orEmpty(),
                            categoryText = shopDataDto?.categoryText.orEmpty()
                        )
                    }
                )
            }.orEmpty()

            val dmgRangeEntities: List<DamageRangeEntity?>? = apiResult?.flatMap { weaponDto ->
                weaponDto.weaponStats?.dmgRange?.map { damageRange ->
                    DamageRangeEntity(
                        id = weaponDto.id + damageRange.startRange + damageRange.endRange,
                        weaponId = weaponDto.id.orEmpty(),
                        startRange = damageRange.startRange.orEmpty(),
                        endRange = damageRange.endRange.orEmpty(),
                        headDmg = damageRange.headDmg.orEmpty(),
                        bodyDmg = damageRange.bodyDmg.orEmpty(),
                        legDmg = damageRange.legDmg.orEmpty()
                    )
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

    private fun WeaponInfo.asDomain(): WeaponsDomain {
        return WeaponsDomain(
            id = weapon.id,
            name = weapon.name,
            category = weapon.category,
            weaponImg = weapon.weaponImg,
            weaponStats = weapon.weaponStats.let { weaponStatsEntity ->
                WeaponStatsDomain(
                    fireRate = weaponStatsEntity.fireRate,
                    magazineSize = weaponStatsEntity.magazineSize,
                    runSpeedMultiplier = weaponStatsEntity.runSpeedMultiplier,
                    equipTimeSecond = weaponStatsEntity.equipTimeSecond,
                    reloadTimeSecond = weaponStatsEntity.reloadTimeSecond,
                    wallPenetration = weaponStatsEntity.wallPenetration,
                    fireMode = weaponStatsEntity.fireMode
                )
            },
            shopData = weapon.shopData.let { shopDataEntity ->
                ShopDataDomain(
                    cost = shopDataEntity.cost,
                    category = shopDataEntity.category,
                    categoryText = shopDataEntity.categoryText
                )
            },
            dmgRange = dmgRange.map { damageRangeEntity ->
                DamageRangeDomain(
                    startRange = damageRangeEntity.startRange,
                    endRange = damageRangeEntity.endRange,
                    headDmg = damageRangeEntity.headDmg,
                    bodyDmg = damageRangeEntity.bodyDmg,
                    legDmg = damageRangeEntity.legDmg
                )
            }
        )
    }

}