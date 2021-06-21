package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.DamageRangeEntity
import com.kz.valocheck.network.DamageRangeDto
import com.kz.valocheck.network.WeaponDto

fun DamageRangeDto?.asEntity(weaponDto: WeaponDto) : DamageRangeEntity {
    return this.run {
        DamageRangeEntity(
            id = weaponDto.id + this?.startRange + this?.endRange,
            weaponId = weaponDto.id.orEmpty(),
            startRange = this?.startRange.orEmpty(),
            endRange = this?.endRange.orEmpty(),
            headDmg = this?.headDmg.orEmpty(),
            bodyDmg = this?.bodyDmg.orEmpty(),
            legDmg = this?.legDmg.orEmpty()
        )
    }
}