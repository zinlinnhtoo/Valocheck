package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.WeaponInfo
import com.kz.valocheck.domain.DamageRangeDomain
import com.kz.valocheck.domain.ShopDataDomain
import com.kz.valocheck.domain.WeaponStatsDomain
import com.kz.valocheck.domain.WeaponsDomain

fun WeaponInfo.asDomain(): WeaponsDomain {
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
                equipTimeSeconds = weaponStatsEntity.equipTimeSeconds,
                reloadTimeSeconds = weaponStatsEntity.reloadTimeSeconds,
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