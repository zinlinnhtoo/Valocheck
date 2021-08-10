package com.kz.valocheck.network

import com.squareup.moshi.Json

data class WeaponResponse(
    val status: Int?,
    val data: List<WeaponDto>?
)

data class WeaponDetailResponse(
    val status: Int?,
    val data: WeaponDto?
)

data class WeaponDto(
    @Json(name = "uuid") val id: String?,
    @Json(name = "displayName") val name: String?,
    val category: String?,
    @Json(name = "displayIcon") val weaponImg: String?,
    @Json(name = "weaponStats") val weaponStats: WeaponStatsDto?,
    val shopData: ShopDataDto?,
)

data class WeaponStatsDto(
    val fireRate: String?,
    val magazineSize: String?,
    val runSpeedMultiplier: String?,
    val equipTimeSeconds: String?,
    val reloadTimeSeconds: String?,
    val wallPenetration: String?,
    val fireMode: String?,
    @Json(name = "damageRanges") val dmgRange: List<DamageRangeDto>?
)

data class ShopDataDto(
    val cost: String?,
    val category: String?,
    val categoryText: String?
)

data class DamageRangeDto(
    @Json(name = "rangeStartMeters") val startRange: String?,
    @Json(name = "rangeEndMeters") val endRange: String?,
    @Json(name = "headDamage") val headDmg: String?,
    @Json(name = "bodyDamage") val bodyDmg: String?,
    @Json(name = "legDamage") val legDmg: String?
)


//fun WeaponResponse?.asDomain(): List<WeaponsDomain> {
//    return this?.data?.map {
//        WeaponsDomain(
//            id = it.id.orEmpty(),
//            name = it.name.orEmpty(),
//            category = it.category.orEmpty(),
//            weaponImg = it.weaponImg.orEmpty(),
//            weaponStats = it.weaponStats.asDomain(),
//            shopData = it.shopData.asDomain(),
//            dmgRange = it.dmgRange?.map { dmgRangeDto ->
//                dmgRangeDto.asDomain()
//            }.orEmpty()
//        )
//    }.orEmpty()
//}
//
//fun WeaponDto?.asDomain(): WeaponsDomain {
//    return WeaponsDomain(
//        id = this?.id.orEmpty(),
//        name = this?.name.orEmpty(),
//        category = this?.category.orEmpty(),
//        weaponImg = this?.weaponImg.orEmpty(),
//        weaponStats = this?.weaponStats.asDomain(),
//        shopData = this?.shopData.asDomain(),
//        dmgRange = this?.dmgRange?.map {
//            it.asDomain()
//        }.orEmpty()
//    )
//}
//
//
//fun WeaponStatsDto?.asDomain() : WeaponStatsDomain {
//    return this?.run {
//        WeaponStatsDomain(
//            fireRate = fireRate.orEmpty(),
//            magazineSize = magazineSize.orEmpty(),
//            runSpeedMultiplier = runSpeedMultiplier.orEmpty(),
//            equipTimeSecond = equipTimeSecond.orEmpty(),
//            reloadTimeSecond = reloadTimeSecond.orEmpty(),
//            wallPenetration = wallPenetration.orEmpty(),
//            fireMode = fireMode.orEmpty()
//        )
//    } ?: WeaponStatsDomain("","","","","","","")
//}
//
//
//fun ShopDataDto?.asDomain() : ShopDataDomain {
//    return this?.run {
//        ShopDataDomain(
//            cost = cost.orEmpty(),
//            category = category.orEmpty(),
//            categoryText = categoryText.orEmpty()
//        )
//    } ?: ShopDataDomain("","","")
//}
//
//fun DamageRangeDto?.asDomain() : DamageRangeDomain {
//    return DamageRangeDomain(
//        startRange = this?.startRange.orEmpty(),
//        endRange = this?.endRange.orEmpty(),
//        headDmg = this?.headDmg.orEmpty(),
//        bodyDmg = this?.bodyDmg.orEmpty(),
//        legDmg = this?.legDmg.orEmpty()
//    )
//}



