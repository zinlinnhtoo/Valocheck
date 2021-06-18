package com.kz.valocheck.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kz.valocheck.database.dao.AbilityDao
import com.kz.valocheck.database.dao.AgentDao
import com.kz.valocheck.database.dao.RoleDao
import com.kz.valocheck.database.entity.AbilityEntity
import com.kz.valocheck.database.entity.AgentEntity
import com.kz.valocheck.database.entity.RoleEntity

@Database(entities = [AgentEntity::class, RoleEntity::class, AbilityEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun agentDao(): AgentDao
    abstract fun roleDao(): RoleDao
    abstract fun abilityDao(): AbilityDao

    companion object{
        fun create(applicationContext: Context) : AppDatabase {
            return Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "AppDatabase"
            ).allowMainThreadQueries()
                .build()
        }
    }
}