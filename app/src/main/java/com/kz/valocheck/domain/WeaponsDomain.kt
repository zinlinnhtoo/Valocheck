package com.kz.valocheck.domain

data class WeaponsDomain(
    val id: String,
    val name: String,
    val category: String,
    val weaponImg: String,
    val weaponStats: WeaponStatsDomain,
    val shopData: ShopDataDomain,
    val dmgRange: List<DamageRangeDomain>
)

data class WeaponStatsDomain(
    val fireRate: String,
    val magazineSize: String,
    val runSpeedMultiplier: String,
    val equipTimeSecond: String,
    val reloadTimeSecond: String,
    val wallPenetration: String,
    val fireMode: String
)

data class ShopDataDomain(
    val cost: String,
    val category: String,
    val categoryText: String
)

data class DamageRangeDomain(
    val startRange: String,
    val endRange: String,
    val headDmg: String,
    val bodyDmg: String,
    val legDmg: String
)
