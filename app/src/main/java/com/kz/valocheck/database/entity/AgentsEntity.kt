package com.kz.valocheck.database.entity

import androidx.room.*


@Entity(tableName = "agents")
data class AgentEntity(
    @PrimaryKey @ColumnInfo(name = "agent_id") val agentId: String,
    val name: String,
    val profile: String,
    val portrait: String,
    val description: String,
    @ColumnInfo(name = "developer_name") val developerName: String,
)

@Entity(tableName = "roles")
data class RoleEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "role_id") val roleId: String,
    @ColumnInfo(name = "agent_id") val agentId: String,
    val name: String,
    val description: String,
    val icon: String
)

data class AgentAndRole(
    @Embedded val agent: AgentEntity,

    @Relation( parentColumn = "agent_id", entityColumn = "agent_id")
    val role: RoleEntity

)

