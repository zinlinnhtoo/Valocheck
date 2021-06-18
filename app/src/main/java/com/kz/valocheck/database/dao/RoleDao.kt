package com.kz.valocheck.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.kz.valocheck.database.entity.RoleEntity

@Dao
interface RoleDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRole(vararg role: RoleEntity)

}