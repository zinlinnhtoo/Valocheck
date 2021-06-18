package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.AbilityEntity
import com.kz.valocheck.network.AbilityDto

fun AbilityDto?.asEntity(agentId: String) : AbilityEntity? {
    return this?.run {
        AbilityEntity(
            id = slot + agentId,
            abilityAgentId = agentId,
            slot = slot.orEmpty(),
            name = name.orEmpty(),
            description = description.orEmpty(),
            icon = icon.orEmpty()
        )
    }
}
