package com.kz.valocheck.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.kz.valocheck.database.entity.DamageRangeEntity

@Dao
interface DamageRangeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg damageRangeEntity: DamageRangeEntity)

}