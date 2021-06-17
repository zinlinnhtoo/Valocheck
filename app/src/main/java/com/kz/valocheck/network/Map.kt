package com.kz.valocheck.network

import com.kz.valocheck.domain.MapsDomain
import com.kz.valocheck.repo.MapsRepo
import com.squareup.moshi.Json

data class MapResponse(
    val status: Int?,
    val data: List<MapDto>?
)

data class MapDetailResponse(
    val status: Int?,
    val data: MapDto?
)

data class MapDto (
    @Json(name = "uuid") val id: String?,
    @Json(name = "displayName") val name: String?,
    @Json(name = "coordinates") val coordinate: String?,
    @Json(name = "listViewIcon") val mapImg: String?,
    @Json(name = "displayIcon") val miniMapImg: String?,
    val splash: String?
)

fun MapResponse?.asDomain() : List<MapsDomain> {
    return this?.data?.map {
        MapsDomain(
            id = it.id.orEmpty(),
            name = it.name.orEmpty(),
            coordinate = it.coordinate.orEmpty(),
            mapImg = it.mapImg.orEmpty(),
            miniMapImg = it.miniMapImg.orEmpty(),
            splash = it.splash.orEmpty()
        )
    }.orEmpty()
}

fun MapDto?.asDomain() : MapsDomain {
    return MapsDomain(
        id = this?.id.orEmpty(),
        name = this?.name.orEmpty(),
        coordinate = this?.coordinate.orEmpty(),
        mapImg = this?.mapImg.orEmpty(),
        miniMapImg = this?.miniMapImg.orEmpty(),
        splash = this?.splash.orEmpty()
    )
}
