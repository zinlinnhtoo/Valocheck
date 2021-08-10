package com.kz.valocheck.workmanager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.kz.valocheck.repo.AgentsRepo
import com.kz.valocheck.repo.MapsRepo
import com.kz.valocheck.repo.WeaponsRepo

class RefreshWorker(
    appContext: Context,
    workerParams: WorkerParameters,
    private val agentsRepo: AgentsRepo,
    private val mapsRepo: MapsRepo,
    private val weaponsRepo: WeaponsRepo
) :
    CoroutineWorker(appContext, workerParams) {


    override suspend fun doWork(): Result {

        return try {
            agentsRepo.getAgentsList(true)
            mapsRepo.getMapsList()
            weaponsRepo.getWeaponsList()
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }


    }
}