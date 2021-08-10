package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.ShopDataEntity
import com.kz.valocheck.database.entity.WeaponEntity
import com.kz.valocheck.database.entity.WeaponStatsEntity
import com.kz.valocheck.network.WeaponDto

fun WeaponDto?.asEntity() : WeaponEntity {
    return this.run {
        WeaponEntity(
            id =this?.id.orEmpty(),
            name =this?.name.orEmpty(),
            category =this?.category.orEmpty(),
            weaponImg =this?.weaponImg.orEmpty(),
            weaponStats =this?.weaponStats.let { weaponStatsDto ->
                WeaponStatsEntity(
                    fireRate = weaponStatsDto?.fireRate.orEmpty(),
                    magazineSize = weaponStatsDto?.magazineSize.orEmpty(),
                    runSpeedMultiplier = weaponStatsDto?.runSpeedMultiplier.orEmpty(),
                    equipTimeSeconds = weaponStatsDto?.equipTimeSeconds.orEmpty(),
                    reloadTimeSeconds = weaponStatsDto?.reloadTimeSeconds.orEmpty(),
                    wallPenetration = weaponStatsDto?.wallPenetration.orEmpty(),
                    fireMode = weaponStatsDto?.fireMode.orEmpty()
                )
            },
            shopData =this?.shopData.let { shopDataDto ->
                ShopDataEntity(
                    cost = shopDataDto?.cost.orEmpty(),
                    category = shopDataDto?.category.orEmpty(),
                    categoryText = shopDataDto?.categoryText.orEmpty()
                )
            }
        )
    }
}