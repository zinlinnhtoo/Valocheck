package com.kz.valocheck.network

import com.kz.valocheck.domain.AbilityDomain
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.domain.RoleDomain
import com.squareup.moshi.Json

data class AgentResponse(
    val status: Int?,
    val data: List<AgentDto>?
)

data class AgentDto (
    @Json(name = "uuid") val id : String?,
    @Json(name = "displayName") val name: String?,
    @Json(name = "displayIcon")val profile: String?,
    @Json(name = "fullPortrait")val portrait: String?,
    val description: String?,
    val developerName: String?,
    val abilities: List<AbilityDto>?,
    val role: RoleDto?
)

data class AbilityDto(
    val slot : String?,
    @Json(name = "displayName") val name: String?,
    val description: String?,
    @Json(name = "displayIcon") val icon : String?
)

data class RoleDto(
    @Json(name = "uuid") val id: String?,
    @Json(name = "displayName") val name: String?,
    val description: String?,
    @Json(name = "displayIcon") val icon: String?
)

data class  AgentDetailResponse(
    val status: Int?,
    val data: AgentDto?
)

fun AgentResponse?.asDomain() : List<AgentsDomain>{
    return this?.data?.map {
        AgentsDomain(
            id = it.id.orEmpty(),
            name = it.name.orEmpty(),
            profile = it.profile.orEmpty(),
            portrait = it.portrait.orEmpty(),
            description = it.description.orEmpty(),
            developerName = it.developerName.orEmpty(),
            abilities = it.abilities?.map {
                it.asDomain()
            }.orEmpty(),
            role = it.role.asDomain()

        )
    }.orEmpty()
}

fun AgentDto?.asDomain() : AgentsDomain {
    return AgentsDomain(
        id = this?.id.orEmpty(),
        name = this?.name.orEmpty(),
        profile = this?.profile.orEmpty(),
        portrait = this?.portrait.orEmpty(),
        description = this?.description.orEmpty(),
        developerName = this?.developerName.orEmpty(),
        abilities = this?.abilities?.map {
            it.asDomain()
        }.orEmpty(),
        role = this?.role.asDomain()
    )
}

fun AbilityDto.asDomain() : AbilityDomain {
    return AbilityDomain(
        slot = slot.orEmpty(),
        name = name.orEmpty(),
        description = description.orEmpty(),
        icon = icon.orEmpty()
    )
}

fun RoleDto?.asDomain() : RoleDomain {
    return this?.run {
        RoleDomain(
            id = id.orEmpty(),
            name = name.orEmpty(),
            description = description.orEmpty(),
            icon = icon.orEmpty()
        )
    } ?: RoleDomain("", "", "", "")
}