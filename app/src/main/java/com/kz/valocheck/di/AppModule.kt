package com.kz.valocheck.di

import android.content.Context
import com.kz.valocheck.database.dao.AgentDao
import com.kz.valocheck.database.AppDatabase
import com.kz.valocheck.database.dao.AbilityDao
import com.kz.valocheck.database.dao.RoleDao
import com.kz.valocheck.network.BASE_URL
import com.kz.valocheck.network.ValorantApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideValorantApiService(retrofit: Retrofit) : ValorantApiService {
        return retrofit.create(ValorantApiService::class.java)
    }

    @Provides
    fun provideRetrofit(moshi: Moshi) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideMoshi() : Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context)  : AppDatabase {
        return AppDatabase.create(context)
    }

    @Provides
    fun provideAgentDao(appDatabase: AppDatabase) : AgentDao {
        return appDatabase.agentDao()
    }

    @Provides
    fun provideRoleDao(appDatabase: AppDatabase) : RoleDao {
        return appDatabase.roleDao()
    }

    @Provides
    fun provideAbilityDao(appDatabase: AppDatabase) : AbilityDao {
        return appDatabase.abilityDao()
    }
}