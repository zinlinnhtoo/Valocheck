package com.kz.valocheck.mapper

import com.kz.valocheck.domain.AbilityDomain
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.domain.RoleDomain
import com.kz.valocheck.network.AbilityDto
import com.kz.valocheck.network.AgentDto
import com.kz.valocheck.network.AgentResponse
import com.kz.valocheck.network.RoleDto

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

