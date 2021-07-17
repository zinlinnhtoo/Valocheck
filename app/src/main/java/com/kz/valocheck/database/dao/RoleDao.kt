package com.kz.valocheck.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kz.valocheck.database.entity.RoleEntity
import com.kz.valocheck.database.entity.RoleWithAgent

@Dao
interface RoleDao{

    @Query("SELECT * FROM roles")
    fun getRoleList(): LiveData<List<RoleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg role: RoleEntity)

    @Transaction
    @Query("SELECT * FROM roles WHERE name = :roleName")
    suspend fun getRoleWithAgent(roleName: String): List<RoleWithAgent>

}