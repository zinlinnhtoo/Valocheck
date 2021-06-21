package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.MapEntity
import com.kz.valocheck.network.MapDto

fun MapDto?.asEntity() : MapEntity {
    return this.run {
        MapEntity(
            id = this?.id.orEmpty(),
            name = this?.name.orEmpty(),
            coordinate = this?.coordinate.orEmpty(),
            mapImg = this?.mapImg.orEmpty(),
            miniMapImg = this?.miniMapImg.orEmpty(),
            splash = this?.splash.orEmpty()
        )
    }
}