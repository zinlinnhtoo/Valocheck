package com.kz.valocheck.database.dao

import androidx.room.*
import com.kz.valocheck.database.entity.AbilityEntity

@Dao
interface AbilityDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg abilityEntity: AbilityEntity)

}