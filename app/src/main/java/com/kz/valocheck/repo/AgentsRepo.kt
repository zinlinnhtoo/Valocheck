package com.kz.valocheck.repo

import com.kz.valocheck.database.dao.AbilityDao
import com.kz.valocheck.database.dao.AgentDao
import com.kz.valocheck.database.dao.RoleDao
import com.kz.valocheck.database.entity.AbilityEntity
import com.kz.valocheck.database.entity.AgentEntity
import com.kz.valocheck.database.entity.AgentInfo
import com.kz.valocheck.database.entity.RoleEntity
import com.kz.valocheck.domain.AbilityDomain
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.domain.RoleDomain
import com.kz.valocheck.mapper.asDomain
import com.kz.valocheck.mapper.asEntity
import com.kz.valocheck.network.AbilityDto
import com.kz.valocheck.network.AgentDto
import com.kz.valocheck.network.RoleDto
import com.kz.valocheck.network.ValorantApiService
import javax.inject.Inject

class AgentsRepo @Inject constructor(
    private val valorantApiService: ValorantApiService,
    private val agentDao: AgentDao,
    private val roleDao: RoleDao,
    private val abilityDao: AbilityDao
) {

    //get agents
    suspend fun getAgentsList(): List<AgentsDomain> {


        try {
            val result = valorantApiService.getAgentList().body()?.data?.filterNot { it.developerName?.contains("NPE") == true }
            val agentEntities = result?.map {
                AgentEntity(
                    agentId = it.id.orEmpty(),
                    name = it.name.orEmpty(),
                    profile = it.profile.orEmpty(),
                    portrait = it.portrait.orEmpty(),
                    description = it.description.orEmpty(),
                    developerName = it.developerName.orEmpty(),
                    agentRoleId = it.role?.id.orEmpty()
                )
            }.orEmpty()


            val roleEntities: List<RoleEntity?>? = result?.map { agent: AgentDto ->
                agent.role?.let { role: RoleDto ->
                    RoleEntity(
                        roleId = role.id.orEmpty(),
                        name = role.name.orEmpty(),
                        description = role.description.orEmpty(),
                        icon = role.icon.orEmpty()
                    )
                }

            }

            val abilityEntities: List<AbilityEntity?>? = result?.flatMap { agent ->
                agent.abilities?.map {
                    it.asEntity(agent.id.orEmpty())
                }.orEmpty()
            }


            agentDao.insert(*agentEntities.toTypedArray())

            roleEntities?.let {
                roleDao.insert(*it.filterNotNull().toTypedArray())
            }

            abilityEntities?.let {
                abilityDao.insert(*it.filterNotNull().toTypedArray())
            }


        } catch (e: Exception) {

        }

        return agentDao.getList().map { it.asDomain() }
    }

    //get agent detail
    suspend fun getAgentDetails(id: String): AgentsDomain {
        return  agentDao.get(id).asDomain()
    }

    private fun AgentInfo.asDomain(): AgentsDomain {
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


}