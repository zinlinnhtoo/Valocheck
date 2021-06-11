package com.kz.valocheck.domain

data class WeaponsDomain(
    val id: String,
    val name: String,
    val category: String,
    val weaponImg: Int,
    val weaponStats: WeaponStatsDomain,
    val shopData: ShopDataDomain,
    val DmgRange: DamageRangeDomain
)

data class WeaponStatsDomain(
    val fireRate: String,
    val magazineSize: String,
    val runSpeedMultiplier: String,
    val equipTimeSecond: String,
    val reloadTimeSecond: String,
    val wallPenetration: String,
    val fireMode: String,
)

data class ShopDataDomain(
    val cost: String,
    val category: String,
    val categoryText: String,

)

data class DamageRangeDomain(
    val range0To30: Range0To30Domain,
    val range30To50: Range30To50Domain,
)

data class Range0To30Domain(
    val headDmg: String,
    val bodyDmg: String,
    val legDmg: String
)

data class Range30To50Domain(
    val headDmg: String,
    val bodyDmg: String,
    val legDmg: String
)
