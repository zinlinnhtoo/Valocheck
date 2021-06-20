package com.kz.valocheck.database.dao

import androidx.room.*
import com.kz.valocheck.database.entity.WeaponEntity
import com.kz.valocheck.database.entity.WeaponInfo

@Dao
interface WeaponDao {

    @Query("SELECT * FROM weapons")
    fun getList(): List<WeaponInfo>

    @Query("SELECT * FROM weapons WHERE id = :id")
    suspend fun get(id: String) : WeaponInfo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg weapon: WeaponEntity)

    @Delete
    fun delete(weapon: WeaponEntity)
}