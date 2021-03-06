package com.kz.valocheck.database.dao

import androidx.room.*
import com.kz.valocheck.database.entity.AgentEntity
import com.kz.valocheck.database.entity.AgentInfo

@Dao
interface AgentDao {

    @Transaction
    @Query("SELECT * FROM agents")
    suspend fun getList(): List<AgentInfo>

    @Transaction
    @Query("select * from agents where agent_id = :id")
    suspend fun get(id: String): AgentInfo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg agent: AgentEntity)

    @Delete
    suspend fun delete(agent: AgentEntity)
}