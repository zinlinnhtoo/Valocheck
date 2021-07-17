package com.kz.valocheck.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.kz.valocheck.database.dao.AbilityDao
import com.kz.valocheck.database.dao.AgentDao
import com.kz.valocheck.database.dao.RoleDao
import com.kz.valocheck.database.entity.AbilityEntity
import com.kz.valocheck.database.entity.AgentEntity
import com.kz.valocheck.database.entity.RoleEntity
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.domain.RoleDomain
import com.kz.valocheck.mapper.asDomain
import com.kz.valocheck.mapper.asEntity
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
            val result = valorantApiService.getAgentList()
                .body()?.data?.filterNot { it.developerName?.contains("NPE") == true }
            val agentEntities: List<AgentEntity> = result?.map {
                it.asEntity()
            }.orEmpty()


            val roleEntities: List<RoleEntity?>? = result?.map { agent: AgentDto ->
                agent.role?.let { role: RoleDto ->
                    role.asEntity()
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
        return agentDao.get(id).asDomain()
    }


    fun getRoleList(): LiveData<List<RoleDomain>> {
        return roleDao.getRoleList().map { it.map { it.asDomain() } }
    }

    suspend fun getRoleWithAgent(roleName: String): List<AgentsDomain> {
        return roleDao.getRoleWithAgent(roleName).flatMap {
            it.agent.map { agent ->
                AgentsDomain(
                    id = agent.agentId,
                    name = agent.name,
                    profile = agent.profile,
                    portrait = agent.portrait,
                    description = agent.description,
                    developerName = agent.developerName,
                    abilities = emptyList(),
                    role = it.role.asDomain()
                )
            }
        }
    }
}
