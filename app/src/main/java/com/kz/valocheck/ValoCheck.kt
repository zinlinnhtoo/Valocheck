package com.kz.valocheck

import android.app.Application
import androidx.work.*
import com.kz.valocheck.workmanager.RefreshWorker
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class ValoCheck: Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        DarkModeHelper.getInstance(this)
        refreshedDataInit()
    }

    private fun refreshedDataInit() {
        applicationScope.launch {
            setPeriodicWorkerRequest()
        }
    }


    private fun setPeriodicWorkerRequest() {

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .setRequiresCharging(true)
            .build()

        val periodicWorkRequest = PeriodicWorkRequest
            .Builder(RefreshWorker::class.java, 1, TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).cancelAllWork()
        WorkManager.getInstance(this).enqueue(periodicWorkRequest)

    }
}