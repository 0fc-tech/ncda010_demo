package com.example.mod8workmanager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

private const val TAG = "SyncDataWorker"

class SyncDataWorker(
    context : Context,
    params:WorkerParameters
): CoroutineWorker(context,params) {
    override suspend fun doWork(): Result {
        (1..20).forEach {
            Log.i(TAG, "doWork: $it")
            delay(1000)
        }
        return Result.success()
    }
}