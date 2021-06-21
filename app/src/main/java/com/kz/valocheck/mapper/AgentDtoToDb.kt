package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.AgentEntity
import com.kz.valocheck.network.AgentDto

fun AgentDto?.asEntity() : AgentEntity {
    return this.run {
        AgentEntity(
            agentId = this?.id.orEmpty(),
            name = this?.name.orEmpty(),
            profile = this?.profile.orEmpty(),
            portrait = this?.portrait.orEmpty(),
            description = this?.description.orEmpty(),
            developerName = this?.developerName.orEmpty(),
            agentRoleId = this?.role?.id.orEmpty()
        )
    }
}