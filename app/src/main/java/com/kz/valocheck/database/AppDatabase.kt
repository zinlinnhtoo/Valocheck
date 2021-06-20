package com.kz.valocheck.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kz.valocheck.database.dao.*
import com.kz.valocheck.database.entity.*

@Database(
    entities = [
        AgentEntity::class,
        RoleEntity::class,
        AbilityEntity::class,
        MapEntity::class,
        WeaponEntity::class,
        DamageRangeEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun agentDao(): AgentDao
    abstract fun roleDao(): RoleDao
    abstract fun abilityDao(): AbilityDao
    abstract fun mapDao(): MapDao
    abstract fun weaponDao(): WeaponDao
    abstract fun dmgRangeDao(): DamageRangeDao

    companion object {
        fun create(applicationContext: Context): AppDatabase {
            return Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "AppDatabase"
            ).allowMainThreadQueries()
                .build()
        }
    }
}