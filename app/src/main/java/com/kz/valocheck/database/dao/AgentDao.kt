package com.kz.valocheck.database.dao

import androidx.room.*
import com.kz.valocheck.database.entity.AgentAndRole
import com.kz.valocheck.database.entity.AgentEntity

@Dao
interface AgentDao {

    @Transaction
    @Query("SELECT * FROM agents")
    fun getAgentsList(): List<AgentAndRole>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAgent(vararg agents: AgentEntity)

    @Delete
    fun delete(agents: AgentEntity)
}