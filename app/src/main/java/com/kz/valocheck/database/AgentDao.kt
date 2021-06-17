package com.kz.valocheck.database

import androidx.room.Insert
import androidx.room.Query
import retrofit2.http.DELETE

interface AgentDao {

    @Query("SELECT * FROM agents")
    fun getAgentsList(): List<AgentEntity>

    @Insert
    fun insertAgent(vararg agents: AgentEntity)

    @DELETE
    fun delete(agents: AgentEntity)
}