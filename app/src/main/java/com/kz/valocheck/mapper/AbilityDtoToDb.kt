package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.AbilityEntity
import com.kz.valocheck.network.AbilityDto

fun AbilityDto?.asEntity(agentId: String) : AbilityEntity {
    return this.run {
        AbilityEntity(
            id = this?.slot + agentId,
            abilityAgentId = agentId,
            slot = this?.slot.orEmpty(),
            name = this?.name.orEmpty(),
            description = this?.description.orEmpty(),
            icon = this?.icon.orEmpty()
        )
    }
}
