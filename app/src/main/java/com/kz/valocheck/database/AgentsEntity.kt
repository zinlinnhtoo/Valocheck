package com.kz.valocheck.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "agents")
data class AgentEntity(
    @PrimaryKey val id: String?,
    val name: String?,
    val profile: String?,
    val portrait: String?,
    val description: String?,
    @ColumnInfo(name = "developer_name") val developerName: String?
)
