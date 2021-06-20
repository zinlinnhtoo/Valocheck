package com.kz.valocheck.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "maps")
data class MapEntity(
    @PrimaryKey val id: String,
    val name: String,
    val coordinate: String,
    @ColumnInfo(name = "map_img") val mapImg: String,
    @ColumnInfo(name = "mini_map_img")  val miniMapImg: String,
    val splash: String
)