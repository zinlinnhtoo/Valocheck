package com.kz.valocheck.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(AgentEntity::class), version = 1)
abstract class AppDatabase() : RoomDatabase() {

    abstract fun AgentDao(): AgentDao

    companion object{
        fun create(applicationContext: Context) : AppDatabase {
            return Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "AppDatabase"
            ).build()
        }
    }
}