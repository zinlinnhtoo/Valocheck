package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.MapEntity
import com.kz.valocheck.domain.MapsDomain

fun MapEntity.asDomain() : MapsDomain {
    return  MapsDomain(
        id = id,
        name = name,
        coordinate = coordinate,
        mapImg = mapImg,
        miniMapImg = miniMapImg,
        splash = splash
    )
}