package com.kz.valocheck.repo

import com.kz.valocheck.database.dao.AgentDao
import com.kz.valocheck.database.dao.RoleDao
import com.kz.valocheck.database.entity.AgentEntity
import com.kz.valocheck.database.entity.RoleEntity
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.domain.RoleDomain
import com.kz.valocheck.mapper.asDomain
import com.kz.valocheck.network.AgentDto
import com.kz.valocheck.network.RoleDto
import com.kz.valocheck.network.ValorantApiService
import javax.inject.Inject

class AgentsRepo @Inject constructor(
    private val valorantApiService: ValorantApiService,
    private val agentDao: AgentDao,
    private val roleDao: RoleDao
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

            agentDao.insertAgent(*agentEntities.toTypedArray())

            roleEntities?.let {
                roleDao.insertRole(*it.filterNotNull().toTypedArray())
            }


        } catch (e: Exception) {

        }

        return agentDao.getAgentsList().map {
            AgentsDomain(
                id = it.agent.agentId,
                name = it.agent.name,
                profile = it.agent.profile,
                portrait = it.agent.portrait,
                description = it.agent.description,
                developerName = it.agent.developerName,
                abilities = emptyList(),
                role = it.role.let { roleEntity ->
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

    //get agent detail
    suspend fun getAgentDetails(id: String): AgentsDomain {
        return valorantApiService.getAgentDetail(id).body()?.data.asDomain()
    }


}