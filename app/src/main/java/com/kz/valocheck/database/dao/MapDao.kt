package com.kz.valocheck.database.dao

import androidx.room.*
import com.kz.valocheck.database.entity.MapEntity

@Dao
interface MapDao {

    @Query("SELECT * FROM maps")
    fun getList(): List<MapEntity>

    @Query("SELECT * FROM maps WHERE id = :id")
    suspend fun get(id: String): MapEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg map: MapEntity)

    @Delete
    fun delete(map: MapEntity)
}