package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.AbilityEntity
import com.kz.valocheck.database.entity.AgentInfo
import com.kz.valocheck.domain.AbilityDomain
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.domain.RoleDomain

fun AgentInfo.asDomain(): AgentsDomain {
    return AgentsDomain(
        id = agent.agentId,
        name = agent.name,
        profile = agent.profile,
        portrait = agent.portrait,
        description = agent.description,
        developerName = agent.developerName,
        abilities = ability.map { ability: AbilityEntity ->
            AbilityDomain(
                slot = ability.slot,
                name = ability.name,
                description = ability.description,
                icon = ability.icon
            )
        },
        role = role.let { roleEntity ->
            RoleDomain(
                id = roleEntity.roleId,
                name = roleEntity.name,
                description = roleEntity.description,
                icon = roleEntity.icon
            )
        }
    )
}