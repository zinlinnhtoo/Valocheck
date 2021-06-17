package com.kz.valocheck.repo

import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.network.ValorantApiService
import com.kz.valocheck.network.asDomain
import javax.inject.Inject

class AgentsRepo @Inject constructor(private val valorantApiService: ValorantApiService) {


    //get agents
    suspend fun getAgentsList(): List<AgentsDomain> {
        return valorantApiService.getAgentList().body().asDomain()
    }

    //get agent detail
    suspend fun getAgentDetails(id: String): AgentsDomain {
        return valorantApiService.getAgentDetail(id).body()?.data.asDomain()
    }


}